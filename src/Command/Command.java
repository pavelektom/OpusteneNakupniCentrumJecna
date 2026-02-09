package Command;
import KonzoleVeci.Hra;

public interface Command { //hlavni trida pro vsechny commandy
    public String vykonat(Hra hra, String s);
}
