create table medico(
matricula int primary key,
departamento int,
telefone varchar(11),
nome varchar(220),
cargo varchar(220)
);

create table paciente(
id int primary key,
telefone varchar(11),
nome varchar(220),
nascimento date
);

create table historico(
id int primary key,
entrada date,
saida date,
id_medico int, 
id_paciente int,
constraint fk_medico
foreign key (id_medico)
references medico(id),

constraint fk_paciente
foreign key (id_paciente)
references paciente(id)
);

alter table historico
add column descricao varchar

SELECT paciente AS id_paciente, COUNT(*) as internacao
FROM paciente 
JOIN historico 
ON paciente.id = historico.id_paciente
GROUP BY paciente
order by internacao desc ;

select * from paciente.id 



select * from paciente p 
inner join historico h 
on p.id = h.id_paciente 
order by h.id_paciente desc
