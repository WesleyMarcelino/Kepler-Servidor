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

public class TelaIndustria extends JFrame {
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
	private JButton botaoSalvar;
	private JButton botaoCancelar;
	private JButton botaoDeletar;
	private JComboBox<Object> selecaoDeStatus;
	private JTextField status;
	private JPanel formulario;
	private JPanel rodape;
	private JTextField textoRodape;
	private Font fonteTextoRodape;
	private long id;

	public TelaIndustria(Industria industria) {
		BorderLayout layoutTelaInicial = new BorderLayout();
		this.setTitle(Informacoes.getNomedoprograma() + " "
				+ Informacoes.getVersao());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600, 400);
		this.setResizable(false);
		this.add(Titulo(), layoutTelaInicial.NORTH);
		this.add(Formulario(industria), layoutTelaInicial.CENTER);
		this.add(Rodape(), layoutTelaInicial.SOUTH);
		this.setLocationRelativeTo(null);

	}

	private JPanel Titulo() {
		fonteTextoDoTitulo = new Font("Calibri", Font.PLAIN, 24);
		titulo = new JPanel();
		textoDoTitulo = new JLabel();
		textoDoTitulo.setFont(fonteTextoDoTitulo);
		textoDoTitulo.setText("Alteração de industria");
		titulo.add(textoDoTitulo);
		return titulo;
	}

	private JPanel Formulario(final Industria industria) {
		id = industria.getId();
		GridLayout layoutFormulario = new GridLayout(9, 3);
		formulario = new JPanel();
		formulario.setLayout(layoutFormulario);
		labelIndustria = new JLabel();
		nomeIndustria = new JTextField(20);
		labelIndustria.setText("Industria : ");
		nomeIndustria.setText(industria.getNome());
		formulario.add(labelIndustria);
		formulario.add(nomeIndustria);
		labelRua = new JLabel();
		labelRua.setText("Endereço : ");
		rua = new JTextField(30);
		rua.setText(industria.getEndereco());
		formulario.add(labelRua);
		formulario.add(rua);
		selecaoDeStatus = new JComboBox<Object>();
		for (int i = 0; i < StatusLista.getEstados().size(); i++) {
			selecaoDeStatus.addItem(StatusLista.getEstados().get(i));
		}
		labelStatus = new JLabel();
		labelStatus.setText("Status : ");
		formulario.add(labelStatus);
		formulario.add(selecaoDeStatus);
		botaoSalvar = new JButton();
		botaoSalvar.setText("Salvar alterações ");
		botaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeAux = nomeIndustria.getText();
				String enderecoAux = rua.getText();
				String statusAux = selecaoDeStatus.getSelectedItem().toString();
				industria.setNome(nomeAux);
				industria.setEndereco(enderecoAux);
				industria.setStatus(statusAux);
				IndustriaM.apagarIndustriaDB();
				System.out.println("tamanho da lista na edição"
						+ Industrias.getIndustrias().size());
				for (int i = 0; i <= Industrias.getIndustrias().size() - 1; i++) {
					System.out.println("DEBUG APAGAR DB ");
					IndustriaM.inserirIndustria(Industrias.getIndustrias().get(
							i));
				}
				Industrias.limparIndustrias();
				// IndustriaM.lerIndustria(industria);
				IndustriaTxt.lerIndustriaTxt(0);// lendo a lista toda
				ControladoraDeTelas.esconderTelaIndustria();
				ControladoraDeTelas.esconderTelaPrincipal();
				try {
					ControladoraDeTelas.mostrarTelaPrincipal();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		botaoDeletar = new JButton();
		botaoDeletar.setText("Deletar");
		botaoDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IndustriaM.apagarIndustriaDB();
				System.out.println("debug : deletar a Industria "
						+ industria.getId() + industria.getNome());
				for (int i = 0; i <= Industrias.getIndustrias().size() - 1; i++) {
					// System.out.println("DEBUG APAGAR DB ");
					System.out
							.println("Industrias ainda existentes antes de remover:"
									+ Industrias.getIndustrias().get(i));
					// IndustriaM.inserirIndustria(Industrias.getIndustrias().get(i));
				}
				Industrias.limparIndustriasPorId((int) industria.getId());
				for (int i = 0; i <= Industrias.getIndustrias().size() - 1; i++) {
					System.out.println("DEBUG APAGAR DB ");
					System.out.println("Industrias ainda existentes :"
							+ Industrias.getIndustrias().get(i));
					IndustriaM.inserirIndustria(Industrias.getIndustrias().get(
							i));
				}
				IndustriaTxt.lerIndustriaTxt(0);// lendo a lista toda
				ControladoraDeTelas.esconderTelaIndustria();
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
				ControladoraDeTelas.esconderTelaIndustria();
				System.out.println("debug : esconderTelaIndustrias");
			}
		});

		formulario.add(botaoSalvar);
		formulario.add(botaoDeletar);
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
