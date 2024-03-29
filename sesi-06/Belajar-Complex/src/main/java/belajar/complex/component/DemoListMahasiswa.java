
package belajar.complex.component;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class DemoListMahasiswa {
    private static JList listMahasiswa = new JList();
    private static final List<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();
    
    public static void isiCombo(){
        //data dimasukkan ke dalam class model
        DefaultComboBoxModel model  = new DefaultComboBoxModel(daftarMahasiswa.toArray());
        
        //pasang model di combo
        listMahasiswa.setModel(model);
    }
    
    public static void tambahList(Mahasiswa data){
        //data untuk ditampilkan dalam combo box
        daftarMahasiswa.add(data);
        isiCombo();
    }
    
    public static void main(String[] xx){
        Mahasiswa m = new Mahasiswa();
        m.setNpm("123");
        m.setNama("Endy");
        tambahIsiList(m);
        
        final JTextField tfNpm = new JTextField(5);
        final JTextField tfNama = new JTextField(20);
        
        JButton btnTambah = new JButton("Tambah");
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("NPM : "));
        panel.add(tfNpm);
        panel.add(new JLabel("Nama : "));
        panel.add(tfNama);
        panel.add(btnTambah);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        
        panel2.add(listMahasiswa);
        
        JPanel panel4 = new JPanel(new FlowLayout);
        panel4.add(new JLabel("Pilihan : "));
        final JTextField tfPilihan = new JTextField(20);
        tfPilihan.setEditTable(false);
        panel4.add(tfPilihan);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(3,1));
        
        panel3.add(panel);
        panel3.add(panel2);
        panel3.add(panel4);
        
        //menginstankan frame
        JFrame fr = new JFrame("Belajar Combo");
        
        fr.getContentPane().add(panel3);
        //ukuran frame
        fr.setSize(800,200);
        
        //posisi ditengah
        fr.setLocationRelativeTo(null);
        
        //tampilkan
        fr.setVisible(true);
        
        //event handler untuk button
        class TambahMahasiswaListener implements ActionListener{
                public void actionPerformed(Action e){
                    String npm = tfNpm.getText();
                    String nama = tfNama.getText();
                    System.out.println("NPM : "+npm);
                    System.out.println("Nama : "+nama);
                    
                    //tambahkan isinya ke dalam combo
                    Mahasiswa x = new Mahasiswa();
                    x.setNpm(npm);
                    x.setNama(nama);
                    tambahIsiList(x);
                    
                    //kosongkan textfield
                    tfNama.setText("");
                    tfNpm.setText("");
                    tfNpm.requestFocus();
    }
}