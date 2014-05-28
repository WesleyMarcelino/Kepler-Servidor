package telas;

import informacoes.Informacoes;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.IndustriaM;
import db.IndustriaTxt;

import objetos.Equipes;
import objetos.Industria;
import objetos.Industrias;
import objetos.StatusLista;

public class CadastrarIndustria extends JFrame {
	private JPanel titulo;
	private JLabel textoDoTitulo;
	private Font fonteTextoDoTitulo;
	private JLabel labelIndustria;
	private JTextField nomeIndustria;
	private JLabel labelRua;
	private JTextField rua;
	private JLabel labelNumero;
	private JTextField numero;
	private JLabel labelCep;
	private JTextField cep;
	private JLabel labelBairro;
	private JTextField bairro;
	private JLabel labelCidade;
	private JTextField cidade;
	private JLabel labelStatus;
	private JButton botaoOk;
	private JButton botaoCancelar;
	private JComboBox<Object> selecaoDeStatus;
	private JTextField status;
	private JPanel formulario;
	private JPanel rodape;
	private JTextField textoRodape;
	private Font fonteTextoRodape;

	public CadastrarIndustria() {
		BorderLayout layoutTelaInicial = new BorderLayout();
		this.setTitle(Informacoes.getNomedoprograma() + " "
				+ Informacoes.getVersao());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600, 400);
		this.setResizable(false);
		this.add(Titulo(), layoutTelaInicial.NORTH);
		this.add(Formulario(), layoutTelaInicial.CENTER);
		this.add(Rodape(), layoutTelaInicial.SOUTH);
		this.setLocationRelativeTo(null);

	}

	private JPanel Titulo() {
		fonteTextoDoTitulo = new Font("Calibri", Font.PLAIN, 24);
		titulo = new JPanel();
		textoDoTitulo = new JLabel();
		textoDoTitulo.setFont(fonteTextoDoTitulo);
		textoDoTitulo.setText("Cadastro de industria");
		titulo.add(textoDoTitulo);
		return titulo;
	}

	private JPanel Formulario() {
		GridLayout layoutFormulario = new GridLayout(8, 3);
		formulario = new JPanel();
		formulario.setLayout(layoutFormulario);
		labelIndustria = new JLabel();
		nomeIndustria = new JTextField(20);
		labelIndustria.setText("Industria : ");
		nomeIndustria.setText("");
		formulario.add(labelIndustria);
		formulario.add(nomeIndustria);
		labelRua = new JLabel();
		labelRua.setText("Endereço : ");
		rua = new JTextField(30);
		rua.setText("");
		formulario.add(labelRua);
		formulario.add(rua);
		labelNumero = new JLabel();
		labelNumero.setText("N°");
		numero = new JTextField(6);
		numero.setText("");
		formulario.add(labelNumero);
		formulario.add(numero);
		labelCep = new JLabel();
		labelCep.setText("CEP :");
		cep = new JTextField(7);
		cep.setText("");
		formulario.add(labelCep);
		formulario.add(cep);
		labelBairro = new JLabel();
		labelBairro.setText("Bairro :");
		bairro = new JTextField(10);
		formulario.add(labelBairro);
		formulario.add(bairro);
		selecaoDeStatus = new JComboBox<Object>();
		for (int i = 0; i < StatusLista.getEstados().size(); i++) {
			selecaoDeStatus.addItem(StatusLista.getEstados().get(i));
		}
		labelStatus = new JLabel();
		labelStatus.setText("Status : ");
		formulario.add(labelStatus);
		formulario.add(selecaoDeStatus);
		botaoOk = new JButton();
		botaoOk.setText("OK");
		botaoOk.addActionListener(new ActionListener() {
			long idAux;

			public void actionPerformed(ActionEvent e) {
				System.out.println("Tamanho da lista de industrias atual"
						+ Industrias.getIndustrias().size());
				if (Industrias.getIndustrias().size() == 0) {
					idAux = 0;
				} else {
					idAux = Industrias.getIndustrias().size();
					System.out.println("tamanho diferente de 0, idAux é igual "
							+ idAux);
				}
				String nomeAux = nomeIndustria.getText();
				String ruaAux = rua.getText();
				String numeroAux = numero.getText();
				String bairroAux = bairro.getText();
				String cepAux = cep.getText();
				String statusAux = selecaoDeStatus.getSelectedItem().toString();
				String enderecoAux = ruaAux + ", N° " + numeroAux + ", CEP : "
						+ cepAux + ", Bairro :" + bairroAux;
				Industria industriaAux = new Industria(idAux, nomeAux,
						enderecoAux, statusAux);
				IndustriaM.inserirIndustria(industriaAux);
				IndustriaTxt.lerIndustriaTxt(0); // aqui na verdade estou lendo
													// a lista inteira
				ControladoraDeTelas.esconderCadastrarIndustrias();
				ControladoraDeTelas.esconderTelaPrincipal();
				try {
					ControladoraDeTelas.mostrarTelaPrincipal();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		botaoCancelar = new JButton();
		botaoCancelar.setText("Cancelar");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladoraDeTelas.esconderCadastrarIndustrias();
				System.out.println("esconderCadastrarIndustrias");

			}
		});

		formulario.add(botaoOk);
		formulario.add(botaoCancelar);

		return formulario;
	}

	private JPanel Rodape() {
		rodape = new JPanel();
		textoRodape = new JTextField();
		textoRodape.setText(Informacoes.getNomedoprograma());
		fonteTextoRodape = new Font("Calibri", Font.PLAIN, 12);
		textoRodape.setFont(fonteTextoRodape);
		textoRodape.setEditable(false);
		rodape.add(textoRodape);
		return rodape;
	}

}
