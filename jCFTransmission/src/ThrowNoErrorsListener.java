import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ThrowNoErrorsListener extends BaseErrorListener {

   public static final ThrowNoErrorsListener INSTANCE = new ThrowNoErrorsListener();

   @Override
   public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
      {
        //This is left intentionally blank. In this mode, no errors are reported.
      }
}