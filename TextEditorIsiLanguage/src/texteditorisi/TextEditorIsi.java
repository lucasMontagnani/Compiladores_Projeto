package texteditorisi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * A simple example showing how create an "Edit" menu from the same
 * actions used by RSyntaxTextArea.<p>
 *
 * This example uses RSyntaxTextArea 3.0.5.
 */
class TextEditorIsi extends JFrame implements ActionListener{

    JPanel cp = new JPanel(new BorderLayout());

    RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);

    public TextEditorIsi() {

	    AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory)TokenMakerFactory.getDefaultInstance();
	    atmf.putMapping("text/isiLanguage", "texteditorisi.IsiLanguageTokenMaker");
	    textArea.setSyntaxEditingStyle("text/isiLanguage");

        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        cp.add(sp);

        setContentPane(cp);
        setTitle("Editor de texto Isi Language");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

       // Create a menu bar
 		JMenuBar menuBar = new JMenuBar();

 		// Create a menu File for menu
 		JMenu menuFile = new JMenu("File");

 		JMenuItem newItem = new JMenuItem("New");
 		JMenuItem openItem = new JMenuItem("Open");
 		JMenuItem saveItem = new JMenuItem("Save");
 		JMenuItem printItem = new JMenuItem("Print");

 		newItem.addActionListener(this);
 		openItem.addActionListener(this);
 		saveItem.addActionListener(this);
 		printItem.addActionListener(this);

 		menuFile.add(newItem);
 		menuFile.add(openItem);
 		menuFile.add(saveItem);
 		menuFile.add(printItem);

 		// Create a menu Edit for menu
 		JMenu menuEdit = new JMenu("Edit");

 		// Create menu items
 		JMenuItem cutItem = new JMenuItem("cut");
 		JMenuItem copyItem = new JMenuItem("copy");
 		JMenuItem pasteItem = new JMenuItem("paste");

 		// Add action listener
 		cutItem.addActionListener(this);
 		copyItem.addActionListener(this);
 		pasteItem.addActionListener(this);

 		menuEdit.add(cutItem);
 		menuEdit.add(menuEdit);
 		menuEdit.add(pasteItem);

 		menuBar.add(menuFile);
 		menuBar.add(menuEdit);

 		setJMenuBar(menuBar);

    }


    @Override
	public void actionPerformed(ActionEvent e) {

		String s = e.getActionCommand();

			if (s.equals("Save")) {
			// Create an object of JFileChooser class
			JFileChooser j = new JFileChooser("f:");

			// Invoke the showsSaveDialog function to show the save dialog
			int r = j.showSaveDialog(null);

			if (r == JFileChooser.APPROVE_OPTION) {

				// Set the label to the path of the selected directory
				File fi = new File(j.getSelectedFile().getAbsolutePath());

				try {
					// Create a file writer
					FileWriter wr = new FileWriter(fi, false);

					// Create buffered writer to write
					BufferedWriter w = new BufferedWriter(wr);

					// Write
					w.write(textArea.getText());

					w.flush();
					w.close();
				}
				catch (Exception evt) {
					JOptionPane.showMessageDialog(cp, evt.getMessage());
				}
			}
			// If the user cancelled the operation
			else
				JOptionPane.showMessageDialog(cp, "the user cancelled the operation");
		}
		else if (s.equals("Print")) {
			try {
				// print the file
				textArea.print();
			}
			catch (Exception evt) {
				JOptionPane.showMessageDialog(cp, evt.getMessage());
			}
		}
		else if (s.equals("Open")) {
			// Create an object of JFileChooser class
			JFileChooser j = new JFileChooser("f:");

			// Invoke the showsOpenDialog function to show the save dialog
			int r = j.showOpenDialog(null);

			// If the user selects a file
			if (r == JFileChooser.APPROVE_OPTION) {
				// Set the label to the path of the selected directory
				File fi = new File(j.getSelectedFile().getAbsolutePath());

				try {
					// String
					String s1 = "", sl = "";

					// File reader
					FileReader fr = new FileReader(fi);

					// Buffered reader
					BufferedReader br = new BufferedReader(fr);

					// Initialize sl
					sl = br.readLine();

					// Take the input from the file
					while ((s1 = br.readLine()) != null) {
						sl = sl + "\n" + s1;
					}

					// Set the text
					textArea.setText(sl);
				}
				catch (Exception evt) {
					JOptionPane.showMessageDialog(cp, evt.getMessage());
				}
			}
			// If the user cancelled the operation
			else
				JOptionPane.showMessageDialog(cp, "the user cancelled the operation");
		}
		else if (s.equals("New")) {
			textArea.setText("");
		}

	}

    public static void main(String[] args) {
        // Start all Swing applications on the EDT.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
                new TextEditorIsi().setVisible(true);

            }
        });
    }

}