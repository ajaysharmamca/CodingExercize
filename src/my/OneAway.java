package my;

public class OneAway {

    public static void main(String[] args) {

        System.out.println(oneEditAway("pale", "ple"));   // true (remove 'a')
        System.out.println(oneEditAway("pale", "bale"));  // true (replace 'p' with 'b')
        System.out.println(oneEditAway("pale", "pales")); // true (insert 's')
        System.out.println(oneEditAway("pale", "bake"));  // false (two edits)
    }

    public static boolean oneEditAway(String s1, String s2) {

        // Step 1: If length difference is more than 1 → impossible with one edit
        if (Math.abs(s1.length() - s2.length()) > 1)
            return false;

        // Step 2: Identify shorter and longer string
        // This simplifies handling insert/remove cases
        String shorter = s1.length() < s2.length() ? s1 : s2;
        String longer  = s1.length() < s2.length() ? s2 : s1;

        // Step 3: Two pointers for both strings
        int i = 0; // pointer for shorter string
        int j = 0; // pointer for longer string

        // Step 4: Track whether we already found a difference
        boolean foundDifference = false;

        // Step 5: Traverse both strings
        while (i < shorter.length() && j < longer.length()) {

            // If characters are different
            if (shorter.charAt(i) != longer.charAt(j)) {

                // If we already saw a mismatch earlier
                // then this becomes the second edit → return false
                if (foundDifference)
                    return false;

                // Mark that we found the first difference
                foundDifference = true;

                // If lengths are same → replacement case
                // Move pointer of shorter string also
                if (shorter.length() == longer.length()) {
                    i++;
                }

                // If lengths are different → insertion/removal case
                // Only move pointer of longer string
            } 
            else {
                // Characters match → move shorter pointer
                i++;
            }

            // Always move pointer of longer string
            j++;
        }

        // If we reach here → strings are at most one edit away
        return true;
    }
}
