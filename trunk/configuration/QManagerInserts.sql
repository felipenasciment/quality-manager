USE `qmanager`;

--
-- Alterações de 07/10/2014
-- 

-- -------------------------------------------------------------------------------------------------------------------
-- Adicionando tipos de pessoa existentes até o momento em `tb_tipo_pessoa`
-- -------------------------------------------------------------------------------------------------------------------

INSERT INTO `tb_tipo_pessoa`(`id_tipo_pessoa`, `nm_tipo`) VALUES (1, 'COORDENADOR');

INSERT INTO `tb_tipo_pessoa`(`id_tipo_pessoa`, `nm_tipo`) VALUES (2, 'ORIENTADOR');

INSERT INTO `tb_tipo_pessoa`(`id_tipo_pessoa`, `nm_tipo`) VALUES (3, 'DISCENTE');