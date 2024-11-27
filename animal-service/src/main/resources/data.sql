INSERT
INTO
    animal
    (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte)

-- Os Values TEM QUE ser em aspas simples.
VALUES
    ('Derich', 3, 'SRD', current_date, 'Pulguento', 'Andre', 'Medio');

INSERT
INTO
    animal
    (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_adocao)

-- current_date - 5 pega a data atual e diminui 5 dias, e sim, funciona.
VALUES
    ('Iasmin', 5, 'Lindinha', current_date - 5, 'Uma gracinha', 'Derich Ros', 'Grande', current_date);