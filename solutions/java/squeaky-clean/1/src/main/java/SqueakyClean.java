import java.util.Map;
class SqueakyClean {
    static Map<Character, Character> CHAR_CONVERTER = Map.of(
        '4', 'a',
        '3', 'e',
        '0', 'o',
        '1', 'l',
        '7', 't' 
        );
    static String clean(String identifier) {
        StringBuilder sb  = new StringBuilder();
        boolean isKebalCase = false;
        for (char ch : identifier.toCharArray()){
            if( Character.isWhitespace(ch) ) {
                 sb.append("_");
            } else if (ch  == '-' ) {
                isKebalCase = true;    
            } else {
                char processedChar = CHAR_CONVERTER.getOrDefault(ch, ch);
                if (Character.isLetter(processedChar)) {
                    if (isKebalCase) {
                        processedChar = Character.toUpperCase(processedChar);
                        isKebalCase = false;
                    }
                    sb.append(processedChar);
                }
            }
        }
        return sb.toString();
    }
}
