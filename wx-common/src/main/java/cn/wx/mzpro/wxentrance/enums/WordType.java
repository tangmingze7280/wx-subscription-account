package cn.wx.mzpro.wxentrance.enums;


public enum WordType {
    NONE("None", 0),
    ENGLISH("English", 1),
    SIMPLIFIEDCHINESE("SimplifiedChinese", 2),
    TRADITIONALCHINESE("TraditionalChinese", 3),
    NUMERIC("Numeric", 4),
    SYMBOL("Symbol", 5),
    SPACE("Space", 6),
    SYNONYM("Synonym", 7); //同义词
    private final String tpye;
    private final Integer code;

    WordType(String tpye, Integer code) {
        this.tpye = tpye;
        this.code = code;
    }

    public static WordType getWtByCode(int code) {
        WordType wordType = null;
        switch (code) {
            case 0:
                wordType = NONE;
                break;
            case 1:
                wordType = ENGLISH;
                break;
            case 2:
                wordType = SIMPLIFIEDCHINESE;
                break;
            case 3:
                wordType = TRADITIONALCHINESE;
                break;
            case 4:
                wordType = NUMERIC;
                break;
            case 5:
                wordType = SYMBOL;
                break;
            case 6:
                wordType = SPACE;
                break;
            case 7:
                wordType = SYNONYM;
                break;
        }
        return wordType;
    }

    public String getTpye() {
        return tpye;
    }

    public Integer getCode() {
        return code;
    }
}
