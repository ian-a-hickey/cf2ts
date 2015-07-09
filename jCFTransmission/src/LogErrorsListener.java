import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class LogErrorsListener extends BaseErrorListener {

   public static final LogErrorsListener INSTANCE = new LogErrorsListener();
   public static String LogFileName = "cf2tsLog.txt";
   //Need to add the error to a file later...
   StringBuilder sb = new StringBuilder();
   @Override
   public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
      {
	   sb.append("\nline ").append(line).append(":").append(charPositionInLine).append(" ").append(msg);
      }
}
