package view;

import javax.swing.JOptionPane;

import controller.CreateController;

public class CreateView {
	public static void main(String[] args) {
		boolean next = true;
		while (next) {
			String trabalho = JOptionPane.showInputDialog("Insira o Nome do Arquivo");
			while (trabalho == null || trabalho.equals("")) {
				trabalho = JOptionPane.showInputDialog("Insira o Nome do Arquivo");
			}
			CreateController cc = new CreateController();
			cc.geraT(trabalho);
			JOptionPane.showMessageDialog(null, "Trabalho Criado");
			next = JOptionPane.showConfirmDialog(null, "Deseja criar outro?") == 0 ? true : false;
		}

	}
}
