public class LogLevels {
    
    public static String message(String logLine) {
        int start = logLine.indexOf(":");
        if (start == -1){
            return "";
        }
        return logLine.substring(start + 1).trim();
    }

    public static String logLevel(String logLine) {
        int start = logLine.indexOf("[") + 1;
        int end = logLine.indexOf("]");
        if (start <= 0 && end == -1){
            return "unknown";
        }
        return logLine.substring(start, end).toLowerCase();
    }

    public static String reformat(String logLine) {
        String message  = message(logLine);
        String level    = logLevel(logLine);
        return String.format("%s (%s)", message, level);
    }
}
