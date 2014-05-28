package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import informacoes.Informacoes;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objetos.Equipes;

public class TelaInicial extends JFrame {
	private JPanel titulo;
	private JLabel textoDoTitulo;
	private Font fonteTextoDoTitulo;
	private JPanel rodape;
	private JTextField textoRodape;
	private Font fonteTextoRodape;
	private JPanel centro;
	private JButton conectar;
	private JComboBox<Object> selecaoDeEquipes;

	public TelaInicial() {
		BorderLayout layoutTelaInicial = new BorderLayout();
		this.setTitle(Informacoes.getNomedoprograma() + " "
				+ Informacoes.getVersao());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 200);
		this.setResizable(false);
		this.add(Titulo(), layoutTelaInicial.NORTH);
		this.add(Centro(), layoutTelaInicial.CENTER);
		this.add(Rodape(), layoutTelaInicial.SOUTH);
		this.setLocationRelativeTo(null);

	}

	private JPanel Titulo() {
		fonteTextoDoTitulo = new Font("Calibri", Font.PLAIN, 24);
		titulo = new JPanel();
		textoDoTitulo = new JLabel();
		textoDoTitulo.setFont(fonteTextoDoTitulo);
		textoDoTitulo.setText(Informacoes.getNomedoprograma());
		titulo.add(textoDoTitulo);
		return titulo;
	}

	private JPanel Centro() {
		FlowLayout layoutCentro = new FlowLayout();
		centro = new JPanel();
		conectar = new JButton();
		conectar.setText("Conectar");
		conectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// aqui tambem abrir a porta do servidor,
				// olhar as industrias
				ControladoraDeTelas.esconderTelaInicial();
				try {
					ControladoraDeTelas.mostrarTelaPrincipal();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		centro.add(conectar, layoutCentro);
		return centro;
	}

	private JPanel Rodape() {
		rodape = new JPanel();
		textoRodape = new JTextField();
		textoRodape.setText("Desenvolvido por : "
				+ Informacoes.getDesenvolvedores());
		fonteTextoRodape = new Font("Calibri", Font.PLAIN, 12);
		textoRodape.setFont(fonteTextoRodape);
		textoRodape.setEditable(false);
		rodape.add(textoRodape);
		return rodape;
	}

}
