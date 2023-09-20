package pass;

public class lc676 {
    private String[] data;

    public void buildDict(String[] dictionary) {
        this.data = dictionary;
    }

    public boolean search(String searchWord) {
        for (String element : data) {
            if (onlyOneCharDifferent(element, searchWord)) {
                return true;
            }
        }

        return false;
    }

    private boolean onlyOneCharDifferent(String element, String searchWord) {
        if (element.length() != searchWord.length()) {
            return false;
        }

        boolean onlyOneCharDifferent = false;

        for (int i = 0; i < element.length(); i++) {
            boolean differentChars = element.charAt(i) != searchWord.charAt(i);

            if (differentChars && !onlyOneCharDifferent) {
                onlyOneCharDifferent = true;
            } else if (differentChars) {
                onlyOneCharDifferent = false;
                break;
            }
        }

        return onlyOneCharDifferent;
    }
}
