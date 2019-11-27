package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JOptionPane;

public class CreateController {
	public void geraT(String trabalho) {
		try {
			File f = new File("C:\\Temp\\" + trabalho + ".zip");
			if (f.exists()) {
				int confirm = JOptionPane.showConfirmDialog(null,
						"Já existe um arquivo com este nome, deseja sobrescreve-lo?");
				if (confirm == 0) {
					f.delete();
				} else if (confirm == 1) {
					int i = 1;
					while (f.exists()) {
						f = new File("C:\\Temp\\" + trabalho + "(" + i + ").zip");
					}
					JOptionPane.showMessageDialog(null, "Será criado um arquivo com nome de " + f.getName());
				} else {
					System.exit(0);
				}

			} else {
				f.createNewFile();
			}
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
			ZipEntry e = new ZipEntry(trabalho + ".txt");
			out.putNextEntry(e);
			int max = (int) (Math.random() * 400000);
			for (int i = 0; i <= max; i++) {
				String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam enim sem, "
						+ "finibus eu urna non, congue vulputate elit. Quisque pharetra turpis et ipsum tincidunt "
						+ "dignissim. Donec rutrum eget risus a efficitur. Nulla convallis nulla quis dui convallis, "
						+ "non auctor lorem sodales. Praesent vitae convallis orci. Fusce blandit convallis ligula, "
						+ "vitae molestie nunc egestas a. Curabitur mattis velit tempus justo ultrices, vel pretium "
						+ "libero sollicitudin. Suspendisse sed porta libero. Etiam at lacus a elit pretium ultrices. "
						+ "Curabitur urna nisi, aliquet in pharetra sed, vehicula a lectus. Donec eu fringilla nibh, "
						+ "id lacinia tellus. Pellentesque in velit lectus. Morbi ultricies mauris a placerat blandit.\n";
				byte[] data = lorem.getBytes();
				out.write(data, 0, data.length);
			}
			out.closeEntry();
			out.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
