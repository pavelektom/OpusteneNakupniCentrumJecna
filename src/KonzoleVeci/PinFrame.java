package KonzoleVeci;

import javax.swing.*;
import java.awt.*;

public class PinFrame extends JFrame {

    private StringBuilder zadanyKod = new StringBuilder();

    public PinFrame(Hra hra) {
        setTitle("");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextField display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.CENTER);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(4, 3, 5, 5));

        // tlacitka od 1 do 9
        for (int i = 1; i <= 9; i++) {
            int cislo = i;
            JButton btn = new JButton(String.valueOf(i)); //udelame novy tlacitko
            btn.setFont(new Font("Arial", Font.BOLD, 22));
            btn.addActionListener(e -> {
                zadanyKod.append(cislo);
                display.setText(zadanyKod.toString());
            });
            grid.add(btn);
        }

        // tlacitko pro smazani pin kodu
        JButton clear = new JButton("✖");
        clear.setFont(new Font("Segoe UI emoji", Font.BOLD, 24));
        clear.addActionListener(e -> {
            zadanyKod.setLength(0);
            display.setText("");
        });
        grid.add(clear);

        // Tlačítko 0
        JButton zero = new JButton("0");
        zero.setFont(new Font("Arial", Font.BOLD, 22));
        zero.addActionListener(e -> {
            zadanyKod.append("0");
            display.setText(zadanyKod.toString());
        });
        grid.add(zero);

        // potvrzujici tlacitko potvrzuji ✅ :D
        JButton ok = new JButton("✅");
        ok.setFont(new Font("Segoe UI emoji", Font.BOLD, 24));
        ok.addActionListener(e -> {
            String kod = zadanyKod.toString();
            String vysledek = hra.zpracujKod(kod);

            JOptionPane.showMessageDialog(this, vysledek);

            if (hra.isEnd() || hra.isExtraZapnuti()) {
                dispose();
            }
        });
        grid.add(ok);

        add(grid, BorderLayout.CENTER);

        setVisible(true);
    }
}