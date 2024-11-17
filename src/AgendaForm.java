import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AgendaForm extends javax.swing.JFrame {

 // Deklarasi komponen GUI
    private JTextField txtNama, txtHari, txtTanggal, txtJam, txtTempat; // Untuk input data kegiatan
    private JButton btnSimpan, btnEdit, btnHapus, btnKeluar; // Tombol untuk aksi
    private JList<String> listKegiatan; // JList untuk menampilkan daftar kegiatan
    private DefaultListModel<String> listModel; // Model untuk mengelola data dalam JList
    private ArrayList<Kegiatan> kegiatanList; // List untuk menyimpan data kegiatan

    // Konstruktor untuk membuat form dan menginisialisasi komponen-komponen
    public AgendaForm() {
     // Set properti dasar untuk JFrame
        setTitle("Agenda Pribadi");
        setSize(400, 400); // Ukuran frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Menutup aplikasi saat frame ditutup
        setLocationRelativeTo(null); // Membuka frame di tengah layar

        // Inisialisasi ArrayList untuk menyimpan kegiatan
        kegiatanList = new ArrayList<>();
        
        // Inisialisasi model untuk JList
        listModel = new DefaultListModel<>();
        
        // Inisialisasi JList dan membungkusnya dengan JScrollPane untuk memungkinkan scrolling
        listKegiatan = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listKegiatan);

        // Inisialisasi JTextField untuk input data kegiatan
        txtNama = new JTextField(20);
        txtHari = new JTextField(20);
        txtTanggal = new JTextField(20);
        txtJam = new JTextField(20);
        txtTempat = new JTextField(20);

        // Inisialisasi tombol aksi
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnKeluar = new JButton("Keluar");

        // Mengatur layout untuk form
        setLayout(new BorderLayout());

        // Panel untuk input data
        JPanel panelInput = new JPanel(new GridLayout(6, 2));
        panelInput.add(new JLabel("Nama Kegiatan:"));
        panelInput.add(txtNama);
        panelInput.add(new JLabel("Hari:"));
        panelInput.add(txtHari);
        panelInput.add(new JLabel("Tanggal:"));
        panelInput.add(txtTanggal);
        panelInput.add(new JLabel("Jam:"));
        panelInput.add(txtJam);
        panelInput.add(new JLabel("Tempat:"));
        panelInput.add(txtTempat);
        add(panelInput, BorderLayout.NORTH);

        // Panel untuk tombol aksi
        JPanel panelButton = new JPanel();
        panelButton.add(btnSimpan);
        panelButton.add(btnEdit);
        panelButton.add(btnHapus);
        panelButton.add(btnKeluar);
        add(panelButton, BorderLayout.CENTER);

        // Panel untuk daftar kegiatan
        add(scrollPane, BorderLayout.SOUTH);

        // Menambahkan event handler untuk tombol aksi
        btnSimpan.addActionListener(e -> simpanKegiatan()); // Menyimpan kegiatan baru
        btnEdit.addActionListener(e -> editKegiatan());     // Mengedit kegiatan yang dipilih
        btnHapus.addActionListener(e -> hapusKegiatan());   // Menghapus kegiatan yang dipilih
        btnKeluar.addActionListener(e -> System.exit(0));   // Menutup aplikasi

        // Menampilkan frame
        setVisible(true);
    }

    // Method untuk menyimpan kegiatan baru
    private void simpanKegiatan() {
        // Mengambil data input dari JTextField
        String nama = txtNama.getText();
        String hari = txtHari.getText();
        String tanggal = txtTanggal.getText();
        String jam = txtJam.getText();
        String tempat = txtTempat.getText();

        // Validasi: pastikan semua field diisi
        if (nama.isEmpty() || hari.isEmpty() || tanggal.isEmpty() || jam.isEmpty() || tempat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!"); // Tampilkan pesan error
        } else {
            // Membuat objek Kegiatan baru dan menyimpannya ke ArrayList
            Kegiatan kegiatan = new Kegiatan(nama, hari, tanggal, jam, tempat);
            kegiatanList.add(kegiatan);
            
            // Menambahkan kegiatan baru ke JList
            listModel.addElement(kegiatan.toString());
            
            // Mengosongkan input field
            clearFields();
        }
    }

    // Method untuk mengedit kegiatan yang dipilih dari JList
    private void editKegiatan() {
        // Mendapatkan index kegiatan yang dipilih
        int selectedIndex = listKegiatan.getSelectedIndex();
        if (selectedIndex != -1) {
            // Mengambil kegiatan yang dipilih dari ArrayList
            Kegiatan kegiatan = kegiatanList.get(selectedIndex);
            
            // Menampilkan data kegiatan yang dipilih di input fields untuk diedit
            txtNama.setText(kegiatan.getNama());
            txtHari.setText(kegiatan.getHari());
            txtTanggal.setText(kegiatan.getTanggal());
            txtJam.setText(kegiatan.getJam());
            txtTempat.setText(kegiatan.getTempat());

            // Menghapus kegiatan yang dipilih dari ArrayList dan JList
            kegiatanList.remove(selectedIndex);
            listModel.remove(selectedIndex);
        } else {
            // Jika tidak ada kegiatan yang dipilih, tampilkan pesan error
            JOptionPane.showMessageDialog(this, "Pilih kegiatan yang ingin diubah.");
        }
    }

    // Method untuk menghapus kegiatan yang dipilih dari JList
    private void hapusKegiatan() {
        // Mendapatkan index kegiatan yang dipilih
        int selectedIndex = listKegiatan.getSelectedIndex();
        if (selectedIndex != -1) {
            // Menghapus kegiatan yang dipilih dari ArrayList dan JList
            kegiatanList.remove(selectedIndex);
            listModel.remove(selectedIndex);
        } else {
            // Jika tidak ada kegiatan yang dipilih, tampilkan pesan error
            JOptionPane.showMessageDialog(this, "Pilih kegiatan yang ingin dihapus.");
        }
    }

    // Method untuk membersihkan semua input fields
    private void clearFields() {
        txtNama.setText("");
        txtHari.setText("");
        txtTanggal.setText("");
        txtJam.setText("");
        txtTempat.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Nama Kegiatan:");

        jLabel2.setText("Hari:");

        jLabel3.setText("Tanggal:");

        jLabel4.setText("Jam:");

        jLabel5.setText("Tempat:");

        jButton1.setText("Simpan");

        jButton2.setText("Edit");

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Keluar");

        jLabel6.setText("Daftar Kegiatan:");

        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(35, 35, 35)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
