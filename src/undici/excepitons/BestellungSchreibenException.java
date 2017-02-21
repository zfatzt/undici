package undici.excepitons;
import java.io.IOException;

public class BestellungSchreibenException extends IOException {
	
	private static final long serialVersionUID = 1L;

	public BestellungSchreibenException(String fehler) {
		super(fehler);

	}

}
