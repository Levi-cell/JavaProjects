insert into medico 
(id,departamento,telefone,nome,cargo)
values
(1,'Enfermaria', '9115588585','Maria Clara', 'Enfermeira Residente'),
(2,'Cirurgia', '87988464300','Claubert', 'Cirurgião Chefe'),
(3,'Setor de Urgência e Emergência', '9115588585','Eduardo Sebastião', 'Socorrista'),
(4,'Setor de Apoio Terapêutico', '9115588585','Kamylla Almeida', 'Fisioterapeutas'),
(5,'Setor de Vigilância em Saúde', '9115588585','Mikael Santos', 'Infectologista')

select * from medico 


insert into paciente
(id,telefone,nome,nascimento)

values 
(1, '11223344556', 'Raphael ', '2001-05-03'),
(2, '11223344556', 'Eládio ', '2000-05-03'),
(3, '11223344556', 'Elânio ', '2000-05-03')

select * from paciente 


insert into historico
(id,entrada,saida, id_medico, id_paciente, descricao)
values
(1,'10/11/2021', '14/11/2021', 1, 1, 'Coração ruim '),
(2,'27/11/2021', '27/10/2021', 2, 2, 'Asma '),
(3,'28/12/2021', '02/01/2022', 2, 2, 'Corona Virus '),
(4,'25/12/2021', '28/12/2021', 1, 3, 'Dengue ')



