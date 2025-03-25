package agenda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compromisso {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String descricao;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Compromisso(LocalDateTime dataInicio, LocalDateTime dataFim, String descricao) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
    }

    public boolean pertencePeriodo(LocalDateTime inicioPeriodo, int numeroDias) {
        LocalDateTime fimPeriodo = inicioPeriodo.plusDays(numeroDias);
        return (dataInicio.isEqual(inicioPeriodo) || dataInicio.isAfter(inicioPeriodo)) && dataInicio.isBefore(fimPeriodo);
    }

    public String toString() {
        return String.format("📅 %s\n⏰ Início: %s\n⏱ Fim: %s\n",
                descricao,
                dataInicio.format(formatter),
                dataFim.format(formatter));
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public String getDescricao() {
        return descricao;
    }
}
