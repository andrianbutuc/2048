package model;

/**
 * This class represent a case of board in game 2048.
 */
public class Case {
    private int value;
    private final int line;
    private final int column;

    /**
     * Constructs a case with default value 0 .
     *
     * @param line   an integer .
     * @param column an integer .
     */
    Case(int line, int column) {
        if (line < 0 || column < 0) {
            throw new IllegalArgumentException("Line or column can't be a negative ");
        }
        this.line = line;
        this.column = column;
        this.value = 0;
    }

    /**
     * Returns case value .
     *
     * @return case value .
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns line value .
     *
     * @return line value .
     */
    int getLine() {
        return line;
    }

    /**
     * Returns column value .
     *
     * @return column value .
     */
    int getColumn() {
        return column;
    }

    /**
     * Checks if the case is empty .
     *
     * @return true if case is empty ,false otherwise.
     */
    boolean isEmpty() {
        return value == 0;
    }

    /**
     * Checks if this case can merge with another one .If another case is null return false .
     *
     * @param caseToMerge a Case .
     * @return true if this  case can merge with another one ,false otherwise .
     */
    boolean merge(Case caseToMerge) {
        if (caseToMerge != null) {
            return value == caseToMerge.getValue() && value != 0;
        } else {
            return false;
        }
    }

    /**
     * Set the value of case .
     *
     * @param value an integer .
     */
    void setValue(int value) {
        this.value = value;
    }
}
