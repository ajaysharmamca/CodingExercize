package my.chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Swing GUI chessboard with click-to-select and click-to-move interaction.
 * Displays an 8x8 board with Unicode chess pieces, alternating square colors,
 * and a status bar showing the current turn.
 */
public class ChessBoardGUI extends JFrame {

    // Unicode chess symbols — white pieces
    private static final String W_KING   = "\u2654";
    private static final String W_QUEEN  = "\u2655";
    private static final String W_ROOK   = "\u2656";
    private static final String W_BISHOP = "\u2657";
    private static final String W_KNIGHT = "\u2658";
    private static final String W_PAWN   = "\u2659";

    // Unicode chess symbols — black pieces
    private static final String B_KING   = "\u265A";
    private static final String B_QUEEN  = "\u265B";
    private static final String B_ROOK   = "\u265C";
    private static final String B_BISHOP = "\u265D";
    private static final String B_KNIGHT = "\u265E";
    private static final String B_PAWN   = "\u265F";

    // Square colors
    private static final Color LIGHT_SQ = new Color(240, 217, 181);
    private static final Color DARK_SQ  = new Color(181, 136,  99);
    private static final Color HIGHLIGHT = new Color(106, 135,  77);
    private static final Color VALID_MOVE = new Color(130, 151, 105);

    // Board state: 8x8 grid, null = empty
    private final String[][] board = new String[8][8];

    // GUI components
    private final JButton[][] squares = new JButton[8][8];
    private final JLabel statusLabel;

    // Interaction state
    private int selectedRow = -1;
    private int selectedCol = -1;
    private boolean whiteTurn = true;

    public ChessBoardGUI() {
        super("Chess Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ignored) {}

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenuItem newGameItem = new JMenuItem("New Game");
        newGameItem.addActionListener(e -> resetGame());
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        gameMenu.add(newGameItem);
        gameMenu.addSeparator();
        gameMenu.add(exitItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        // Board panel
        JPanel boardPanel = new JPanel(new GridLayout(8, 8));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create squares
        Font pieceFont = new Font("SansSerif", Font.PLAIN, 48);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton btn = new JButton();
                btn.setFont(pieceFont);
                btn.setFocusPainted(false);
                btn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

                boolean isDark = (row + col) % 2 != 0;
                btn.setBackground(isDark ? DARK_SQ : LIGHT_SQ);
                btn.putClientProperty("row", row);
                btn.putClientProperty("col", col);

                btn.addActionListener(new SquareClickListener());
                squares[row][col] = btn;
                boardPanel.add(btn);
            }
        }

        // Status panel
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        statusLabel = new JLabel();
        statusLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        statusPanel.add(statusLabel);

        add(boardPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        setupStartingPosition();
        updateBoard();
        updateStatus();

        setSize(520, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /** Reset board to starting position. */
    private void resetGame() {
        selectedRow = -1;
        selectedCol = -1;
        whiteTurn = true;
        clearHighlights();
        setupStartingPosition();
        updateBoard();
        updateStatus();
    }

    /** Set up pieces in standard starting position. */
    private void setupStartingPosition() {
        // Clear board
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                board[r][c] = null;
            }
        }

        // Row 0 — Black major pieces
        board[0][0] = B_ROOK;   board[0][1] = B_KNIGHT;
        board[0][2] = B_BISHOP; board[0][3] = B_QUEEN;
        board[0][4] = B_KING;   board[0][5] = B_BISHOP;
        board[0][6] = B_KNIGHT; board[0][7] = B_ROOK;

        // Row 1 — Black pawns
        for (int c = 0; c < 8; c++) {
            board[1][c] = B_PAWN;
        }

        // Row 6 — White pawns
        for (int c = 0; c < 8; c++) {
            board[6][c] = W_PAWN;
        }

        // Row 7 — White major pieces
        board[7][0] = W_ROOK;   board[7][1] = W_KNIGHT;
        board[7][2] = W_BISHOP; board[7][3] = W_QUEEN;
        board[7][4] = W_KING;   board[7][5] = W_BISHOP;
        board[7][6] = W_KNIGHT; board[7][7] = W_ROOK;
    }

    /** Refresh all square buttons to reflect board state. */
    private void updateBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton btn = squares[row][col];
                String piece = board[row][col];
                btn.setText(piece != null ? piece : "");

                // Reset background (overrides any highlight)
                boolean isDark = (row + col) % 2 != 0;
                btn.setBackground(isDark ? DARK_SQ : LIGHT_SQ);
            }
        }
    }

    /** Update status bar text. */
    private void updateStatus() {
        String turn = whiteTurn ? "White" : "Black";
        statusLabel.setText(turn + "'s turn");
    }

    /** Clear all highlights from the board. */
    private void clearHighlights() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton btn = squares[row][col];
                boolean isDark = (row + col) % 2 != 0;
                btn.setBackground(isDark ? DARK_SQ : LIGHT_SQ);
            }
        }
    }

    /** Highlight the selected square and valid destination squares. */
    private void highlightSelection(int row, int col) {
        clearHighlights();

        // Highlight selected square
        squares[row][col].setBackground(HIGHLIGHT);

        // Determine valid moves (simple — any empty square or opponent piece)
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (r == row && c == col) continue;
                String target = board[r][c];
                if (target == null || isOpponentPiece(target)) {
                    squares[r][c].setBackground(VALID_MOVE);
                }
            }
        }
    }

    /** Determine if a piece symbol represents a white piece. */
    private static boolean isWhitePiece(String piece) {
        return piece.equals(W_KING) || piece.equals(W_QUEEN) ||
               piece.equals(W_ROOK) || piece.equals(W_BISHOP) ||
               piece.equals(W_KNIGHT) || piece.equals(W_PAWN);
    }

    /** Check if a piece belongs to the opponent of the current player. */
    private boolean isOpponentPiece(String piece) {
        return whiteTurn != isWhitePiece(piece);
    }

    /** Check if a piece belongs to the current player. */
    private boolean isCurrentPlayerPiece(String piece) {
        return whiteTurn == isWhitePiece(piece);
    }

    /** Inner class to handle square clicks. */
    private class SquareClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            int row = (int) btn.getClientProperty("row");
            int col = (int) btn.getClientProperty("col");
            String piece = board[row][col];

            // If nothing is selected yet
            if (selectedRow == -1) {
                // Must click on own piece to select
                if (piece != null && isCurrentPlayerPiece(piece)) {
                    selectedRow = row;
                    selectedCol = col;
                    highlightSelection(row, col);
                }
                return;
            }

            // Clicked the same square → deselect
            if (row == selectedRow && col == selectedCol) {
                selectedRow = -1;
                selectedCol = -1;
                clearHighlights();
                return;
            }

            // Clicked a valid destination
            // Allow move to empty square or opponent piece
            if (piece == null || isOpponentPiece(piece)) {
                // Move the piece
                board[row][col] = board[selectedRow][selectedCol];
                board[selectedRow][selectedCol] = null;

                // Switch turn
                whiteTurn = !whiteTurn;

                selectedRow = -1;
                selectedCol = -1;
                updateBoard();
                updateStatus();
            } else {
                // Clicked own piece → switch selection
                selectedRow = row;
                selectedCol = col;
                highlightSelection(row, col);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessBoardGUI gui = new ChessBoardGUI();
            gui.setVisible(true);
        });
    }
}
