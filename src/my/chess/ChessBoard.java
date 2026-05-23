package my.chess;

/**
 * Console-based chessboard display.
 * Prints an 8x8 board with pieces in standard starting position
 * using Unicode chess symbols with dark/light square shading.
 */
public class ChessBoard {

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

    // ANSI background colors for chessboard squares
    private static final String BG_DARK  = "\u001B[48;5;237m";  // dark gray
    private static final String BG_LIGHT = "\u001B[48;5;248m";  // light gray
    private static final String RESET    = "\u001B[0m";         // reset

    // Board representation: 8 rows x 8 cols, null means empty square
    private final String[][] board;

    public ChessBoard() {
        board = new String[8][8];
        setupStartingPosition();
    }

    /** Set up pieces in standard starting position. */
    private void setupStartingPosition() {
        // Row 0 — Black major pieces
        board[0][0] = B_ROOK;   board[0][1] = B_KNIGHT;
        board[0][2] = B_BISHOP; board[0][3] = B_QUEEN;
        board[0][4] = B_KING;   board[0][5] = B_BISHOP;
        board[0][6] = B_KNIGHT; board[0][7] = B_ROOK;

        // Row 1 — Black pawns
        for (int col = 0; col < 8; col++) {
            board[1][col] = B_PAWN;
        }

        // Rows 2-5 — Empty
        for (int row = 2; row <= 5; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = null;
            }
        }

        // Row 6 — White pawns
        for (int col = 0; col < 8; col++) {
            board[6][col] = W_PAWN;
        }

        // Row 7 — White major pieces
        board[7][0] = W_ROOK;   board[7][1] = W_KNIGHT;
        board[7][2] = W_BISHOP; board[7][3] = W_QUEEN;
        board[7][4] = W_KING;   board[7][5] = W_BISHOP;
        board[7][6] = W_KNIGHT; board[7][7] = W_ROOK;
    }

    /** Print the board to console with column/row labels. */
    public void print() {
        System.out.println("  " + horizontalRule());
        for (int row = 0; row < 8; row++) {
            // Row label (rank) — 8 to 1 (top = black side)
            System.out.print((8 - row) + " ");

            for (int col = 0; col < 8; col++) {
                String piece = board[row][col];
                String symbol = (piece == null) ? " " : piece;

                boolean isDark = (row + col) % 2 != 0;
                String bg = isDark ? BG_DARK : BG_LIGHT;
                System.out.print("|" + bg + " " + symbol + " " + RESET);
            }
            System.out.println("|");
            System.out.println("  " + horizontalRule());
        }

        // Column labels (file) — 3 chars per file to match cell width
        System.out.print("   ");
        for (char file = 'a'; file <= 'h'; file++) {
            System.out.print(" " + file + "  ");
        }
        System.out.println();
    }

    /** Draw the horizontal separator line matching 8 cells with 4 visible chars each. */
    private static String horizontalRule() {
        return "  ---------------------------------";
    }

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.print();
    }
}
