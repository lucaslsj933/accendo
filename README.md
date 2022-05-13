# accendo
 
Sistema de notas escolar para o TCC. Talvez irei expandir para um sistema completo escolar no futuro.

# TODO

- Lidar melhor com exceptions em AlunoAndNotasSyncer
- Muitas threads de DB, toda hora o código vai em Main.consultarUI.getSomething...para melhorar isso, lembre-se que todos os atributos e variáveis em java são ponteiros, então use jcbCache=Main.consultarUI.getJcb(); Todas as mudanças em jcbCache alterarão também o Jcb de consultarUI.
- Em profInsertUI, coloque "Escolha a turma" no combo box de turma quando o usuário ainda não escolheu a turma
- No DB, substituir o campo etapa de aluno para uma tabela
- Se a sessão expirar, mostrar mensagem