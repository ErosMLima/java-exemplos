package digytal.java.desktop.form;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import digytal.java.desktop.util.Entidade;
import digytal.java.desktop.util.FormularioUtil;
import digytal.util.desktop.ss.SSBotao;
import digytal.util.desktop.ss.SSCabecalho;
import digytal.util.desktop.ss.SSCaixaCombinacao;
import digytal.util.desktop.ss.SSGrade;
import digytal.util.desktop.ss.SSRodape;

public class FormularioConsulta extends JPanel {
	private SSCabecalho cabecalho = new SSCabecalho();
	private SSRodape rodape = new SSRodape();
	private SSBotao bSair = new SSBotao();
	private SSBotao bNovo = new SSBotao();
	private SSBotao bAlterar = new SSBotao();
	private SSGrade grade = new SSGrade();
	private SSCaixaCombinacao combo = new SSCaixaCombinacao(); 
	private JScrollPane scroll;
	public FormularioConsulta() {
		setSize(500,400);
		cabecalho.setTitulo("Formulario Consulta");
		cabecalho.setDescricao("Exemplo de Formulario de Consulta");
		bSair.setText("Fechar");
		bAlterar.setText("Alterar");
		bNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormularioUtil.exibir(new FormularioCadastro());
			}
		});
		bNovo.setText("Novo");
		
		setLayout(new BorderLayout());
		add(cabecalho,BorderLayout.NORTH);
		add(rodape,BorderLayout.SOUTH);
		
		rodape.setAlinhamento(FlowLayout.LEFT);
		rodape.add(bNovo);
		rodape.add(bAlterar);
		rodape.add(bSair);
		rodape.add(combo);
		
		
		grade.getModeloTabela().addColumn("ID");
		grade.getModeloTabela().addColumn("Nome");
		
		grade.getModeloColuna().getColumn(0).setPreferredWidth(30);
		grade.getModeloColuna().getColumn(1).setPreferredWidth(350);
		
		grade.getModeloColuna().setCampo(0, "id");
		grade.getModeloColuna().setCampo(1, "nome");
		
		scroll = new JScrollPane();
		scroll.setViewportView(grade);
		add(scroll,BorderLayout.CENTER);
		
		List<Entidade> entidades = new ArrayList<Entidade>();
		entidades.add(new Entidade(1, "FRANK MARLON"));
		entidades.add(new Entidade(2, "RAIMUNDO BRANCO"));
		entidades.add(new Entidade(3, "GLEYSON SAMPAIO"));
		entidades.add(new Entidade(4, "RAFAEL ALUNO"));
		
		grade.setValue(entidades);
		
		combo.setItens(entidades, "nome");
		
		
	}
}
