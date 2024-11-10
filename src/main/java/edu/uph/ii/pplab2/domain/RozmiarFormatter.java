package edu.uph.ii.pplab2.domain;

import org.springframework.format.Formatter;
import org.springframework.lang.NonNull;

import java.text.ParseException;
import java.util.Locale;

public class RozmiarFormatter implements Formatter<Rozmiar> {
    @Override
    @NonNull
    public Rozmiar parse(@NonNull String text, @NonNull Locale locale) throws ParseException {
        String[] parts = text.split(" x ");
        return new Rozmiar(Double.parseDouble(parts[0].trim()), Double.parseDouble(parts[1].trim()), Integer.parseInt(parts[2].trim()));
    }

    @Override
    @NonNull
    public String print(@NonNull Rozmiar object, @NonNull Locale locale) {
        return object.toString();
    }
}
