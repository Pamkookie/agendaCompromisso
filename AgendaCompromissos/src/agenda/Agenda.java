package agenda;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Agenda {
    private ArrayList<Compromisso> compromissos;

    public Agenda() {
        compromissos = new ArrayList<>();
    }

    public void adicionarCompromisso(Compromisso novo) {
        compromissos.add(novo);
    }

    public ArrayList<Compromisso> verificarCompromissos() {
        int numeroDias = 7;
        LocalDateTime agora = LocalDateTime.now();
        ArrayList<Compromisso> lista = new ArrayList<>();

        for (Compromisso c : compromissos) {
            if (c.pertencePeriodo(agora, numeroDias)) {
                lista.add(c);
            }
        }

        return lista;
    }
}