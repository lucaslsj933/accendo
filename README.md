# accendo
 
Sistema de notas escolar para o TCC. Talvez irei expandir para um sistema completo escolar no futuro.

# TODO

- Lidar melhor com exceptions em AlunoAndNotasSyncer
- Muitas threads de DB, toda hora o c�digo vai em Main.consultarUI.getSomething...para melhorar isso, lembre-se que todos os atributos e vari�veis em java s�o ponteiros, ent�o use jcbCache=Main.consultarUI.getJcb(); Todas as mudan�as em jcbCache alterar�o tamb�m o Jcb de consultarUI.
- Em profInsertUI, coloque "Escolha a turma" no combo box de turma quando o usu�rio ainda n�o escolheu a turma
- No DB, substituir o campo etapa de aluno para uma tabela
- Se a sess�o expirar, mostrar mensagem