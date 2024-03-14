public class ProjectData {


    private String[] sheets = {"""
        bla
        bla
        bla
          """, """
        ble
        ble
        ble
""","""
    bli
    bli
    bli
    """, """
blo
blo
blo
""", """
blu
blu
blu
"""};

    public String getNextSheet() {
        if (sheetCounter < sheets.length - 1) {
            sheetCounter++;
        }
        return (sheetCounter + 1) + "/" + sheets.length + "\n" + sheets[sheetCounter];
    }

    public String getPreviousSheet() {
        if (sheetCounter > 0) {
            sheetCounter--;
        }
        return (sheetCounter + 1) + "/" + sheets.length + "\n" + sheets[sheetCounter];
    }

    private int sheetCounter = 0;

}
