package pl.com.bottega.documentmanagement.application;

import com.google.common.collect.Lists;

import java.util.Collection;

/**
 * Created by arkadiuszarak on 23/08/2016.
 */
public class ZabawaZMatematykaDlaLicealistowApp extends ConsoleApplication {
    @Override
    protected CommandFactory commandFactory() {
        return new MathematicsCommandFactory();
    }

    @Override
    protected Collection<String> menuItems() {
        return Lists.newArrayList("1. Rozwiaz rownanie kwadratowe",
                "2. Oblicz sinus",
                "3. Oblicz cosinus",
                "4. Oblicz 2 do potegi");
    }

    public static void main(String[] args) {
        new ZabawaZMatematykaDlaLicealistowApp().run();
    }
}
