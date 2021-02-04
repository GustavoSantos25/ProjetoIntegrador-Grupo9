package com.example.projetointegrador.services

import com.example.projetointegrador.dao.ConfiguracoesDAO
import com.example.projetointegrador.dao.FilmeReplaceDAO
import com.example.projetointegrador.dao.PaisMappingDAO
import com.example.projetointegrador.dao.TemplateDAO
import com.example.projetointegrador.database.AppDataBase
import com.example.projetointegrador.domain.*
import com.example.projetointegrador.ui.LoginActivity

interface DBRepository {

    //inserts
    suspend fun addTemplateTask(template: Template): List<Template>
    suspend fun addFilmesReplaceTask(filmeReplace: FilmeReplace): List<FilmeReplace>
    suspend fun addConfiguracoesTask(configuracoes: Configuracoes)
    suspend fun populatePaisesMappingDBService()
    //suspend fun addPais(pais: PaisMapping)

    //selects
    suspend fun getAllTemplatesTask(): List<Template>
    suspend fun getAllFilmesReplaceTask(): List<FilmeReplace>
    suspend fun getAllConfiguracoesTask(): List<Configuracoes>
    suspend fun getConfiguracoesForUserTask(email: String): Configuracoes
    suspend fun getPaisPortuguesDBService(country: String): String
    suspend fun testIsEmptyDBService(): Int

    //updates
    suspend fun updateConfiguracoesTask(configuracoes: Configuracoes): Configuracoes

    //deletes
}

class DBRepositoryImplementation(
    val templateDAO: TemplateDAO, val filmeReplaceDAO: FilmeReplaceDAO,
    val configuracoesDAO: ConfiguracoesDAO, val paisMappingDAO: PaisMappingDAO
) : DBRepository {

    override suspend fun addTemplateTask(template: Template): List<Template> {
        templateDAO.addTemplateQuestion(template)
        return templateDAO.getAllTemplates()
    }

    override suspend fun addFilmesReplaceTask(filmeReplace: FilmeReplace): List<FilmeReplace> {
        filmeReplaceDAO.addFilmeReplace(filmeReplace)
        return filmeReplaceDAO.getAllFilmesReplace()
    }

    override suspend fun addConfiguracoesTask(configuracoes: Configuracoes) = configuracoesDAO.addConfiguracoes(configuracoes)
    override suspend fun populatePaisesMappingDBService() {
        val paises = listOf<PaisMapping>(
            PaisMapping(1, "AFEGANISTÃO", "AFGHANISTAN"),
            PaisMapping(2, "ACROTÍRI E DECELIA", "AKROTIRI E DEKÉLIA"),
            PaisMapping(3, "ÁFRICA DO SUL", "SOUTH AFRICA"),
            PaisMapping(4, "ALBÂNIA", "ALBANIA"),
            PaisMapping(5, "ALEMANHA", "GERMANY"),
            PaisMapping(6, "AMERICAN SAMOA", "AMERICAN SAMOA"),
            PaisMapping(7, "ANDORRA", "ANDORRA"),
            PaisMapping(8, "ANGOLA", "ANGOLA"),
            PaisMapping(9, "ANGUILLA", "ANGUILLA"),
            PaisMapping(10, "ANTÍGUA E BARBUDA", "ANTIGUA AND BARBUDA"),
            PaisMapping(11, "ANTILHAS NEERLANDESAS", "NETHERLANDS ANTILLES"),
            PaisMapping(12, "ARÁBIA SAUDITA", "SAUDI ARABIA"),
            PaisMapping(13, "ARGÉLIA", "ALGERIA"),
            PaisMapping(14, "ARGENTINA", "ARGENTINA"),
            PaisMapping(15, "ARMÉNIA", "ARMENIA"),
            PaisMapping(16, "ARUBA", "ARUBA"),
            PaisMapping(17, "AUSTRÁLIA", "AUSTRALIA"),
            PaisMapping(18, "ÁUSTRIA", "AUSTRIA"),
            PaisMapping(19, "AZERBAIJÃO", "AZERBAIJAN"),
            PaisMapping(20, "BAHAMAS", "BAHAMAS, THE"),
            PaisMapping(21, "BANGLADECHE", "BANGLADESH"),
            PaisMapping(22, "BARBADOS", "BARBADOS"),
            PaisMapping(23, "BARÉM", "BAHRAIN"),
            PaisMapping(24, "BASSAS DA ÍNDIA", "BASSAS DA INDIA"),
            PaisMapping(25, "BÉLGICA", "BELGIUM"),
            PaisMapping(26, "BELIZE", "BELIZE"),
            PaisMapping(27, "BENIM", "BENIN"),
            PaisMapping(28, "BERMUDAS", "BERMUDA"),
            PaisMapping(29, "BIELORRÚSSIA", "BELARUS"),
            PaisMapping(30, "BOLÍVIA", "BOLIVIA"),
            PaisMapping(31, "BÓSNIA E HERZEGOVINA", "BOSNIA AND HERZEGOVINA"),
            PaisMapping(32, "BOTSUANA", "BOTSWANA"),
            PaisMapping(33, "BRASIL", "BRAZIL"),
            PaisMapping(34, "BRUNEI DARUSSALAM", "BRUNEI DARUSSALAM"),
            PaisMapping(35, "BULGÁRIA", "BULGARIA"),
            PaisMapping(36, "BURQUINA FASO", "BURKINA FASO"),
            PaisMapping(37, "BURUNDI", "BURUNDI"),
            PaisMapping(38, "BUTÃO", "BHUTAN"),
            PaisMapping(39, "CABO VERDE", "CAPE VERDE"),
            PaisMapping(40, "CAMARÕES", "CAMEROON"),
            PaisMapping(41, "CAMBOJA", "CAMBODIA"),
            PaisMapping(42, "CANADÁ", "CANADA"),
            PaisMapping(43, "CATAR", "QATAR"),
            PaisMapping(44, "CAZAQUISTÃO", "KAZAKHSTAN"),
            PaisMapping(45, "CENTRO-AFRICANA REPÚBLICA", "CENTRAL AFRICAN REPUBLIC"),
            PaisMapping(46, "CHADE", "CHAD"),
            PaisMapping(47, "CHILE", "CHILE"),
            PaisMapping(48, "CHINA", "CHINA"),
            PaisMapping(49, "CHIPRE", "CYPRUS"),
            PaisMapping(50, "COLÔMBIA", "COLOMBIA"),
            PaisMapping(51, "COMORES", "COMOROS"),
            PaisMapping(52, "CONGO", "CONGO"),
            PaisMapping(53, "CONGO REPÚBLICA DEMOCRÁTICA", "CONGO DEMOCRATIC REPUBLIC"),
            PaisMapping(54, "COREIA DO NORTE", "KOREA NORTH"),
            PaisMapping(55, "COREIA DO SUL", "KOREA SOUTH"),
            PaisMapping(56, "COSTA DO MARFIM", "IVORY COAST"),
            PaisMapping(57, "COSTA RICA", "COSTA RICA"),
            PaisMapping(58, "CROÁCIA", "CROATIA"),
            PaisMapping(59, "CUBA", "CUBA"),
            PaisMapping(60, "DINAMARCA", "DENMARK"),
            PaisMapping(61, "DOMÍNICA", "DOMINICA"),
            PaisMapping(62, "EGIPTO", "EGYPT"),
            PaisMapping(63, "EMIRADOS ÁRABES UNIDOS", "UNITED ARAB EMIRATES"),
            PaisMapping(64, "EQUADOR", "ECUADOR"),
            PaisMapping(65, "ERITREIA", "ERITREA"),
            PaisMapping(66, "ESLOVÁQUIA", "SLOVAKIA"),
            PaisMapping(67, "ESLOVÉNIA", "SLOVENIA"),
            PaisMapping(68, "ESPANHA", "SPAIN"),
            PaisMapping(69, "ESTADOS UNIDOS", "UNITED STATES"),
            PaisMapping(70, "ESTÓNIA", "ESTONIA"),
            PaisMapping(71, "ETIÓPIA", "ETHIOPIA"),
            PaisMapping(72, "FAIXA DE GAZA", "GAZA STRIP"),
            PaisMapping(73, "FIJI", "FIJI"),
            PaisMapping(74, "FILIPINAS", "PHILIPPINES"),
            PaisMapping(75, "FINLÂNDIA", "FINLAND"),
            PaisMapping(76, "FRANÇA", "FRANCE"),
            PaisMapping(77, "GABÃO", "GABON"),
            PaisMapping(78, "GÂMBIA", "GAMBIA"),
            PaisMapping(79, "GANA", "GHANA"),
            PaisMapping(80, "GEÓRGIA", "GEORGIA"),
            PaisMapping(81, "GIBRALTAR", "GIBRALTAR"),
            PaisMapping(82, "GRANADA", "GRENADA"),
            PaisMapping(83, "GRÉCIA", "GREECE"),
            PaisMapping(84, "GRONELÂNDIA", "GREENLAND"),
            PaisMapping(85, "GUADALUPE", "GUADELOUPE"),
            PaisMapping(86, "GUAM", "GUAM"),
            PaisMapping(87, "GUATEMALA", "GUATEMALA"),
            PaisMapping(88, "GUERNSEY", "GUERNSEY"),
            PaisMapping(89, "GUIANA", "GUYANA"),
            PaisMapping(90, "GUIANA FRANCESA", "FRENCH GUIANA"),
            PaisMapping(91, "GUINÉ", "GUINEA"),
            PaisMapping(92, "GUINÉ EQUATORIAL", "EQUATORIAL GUINEA"),
            PaisMapping(93, "GUINÉ-BISSAU", "GUINEA-BISSAU"),
            PaisMapping(94, "HAITI", "HAITI"),
            PaisMapping(95, "HONDURAS", "HONDURAS"),
            PaisMapping(96, "HONG KONG", "HONG KONG"),
            PaisMapping(97, "HUNGRIA", "HUNGARY"),
            PaisMapping(98, "IÉMEN", "YEMEN"),
            PaisMapping(99, "ILHA BOUVET", "BOUVET ISLAND"),
            PaisMapping(100, "ILHA CHRISTMAS", "CHRISTMAS ISLAND"),
            PaisMapping(101, "ILHA DE CLIPPERTON", "CLIPPERTON ISLAND"),
            PaisMapping(102, "ILHA DE JOÃO DA NOVA", "JUAN DE NOVA ISLAND"),
            PaisMapping(103, "ILHA DE MAN", "ISLE OF MAN"),
            PaisMapping(104, "ILHA DE NAVASSA", "NAVASSA ISLAND"),
            PaisMapping(105, "ILHA EUROPA", "EUROPA ISLAND"),
            PaisMapping(106, "ILHA NORFOLK", "NORFOLK ISLAND"),
            PaisMapping(107, "ILHA TROMELIN", "TROMELIN ISLAND"),
            PaisMapping(108, "ILHAS ASHMORE E CARTIER", "ASHMORE AND CARTIER ISLANDS"),
            PaisMapping(109, "ILHAS CAIMAN", "CAYMAN ISLANDS"),
            PaisMapping(110, "ILHAS COCOS PaisMapping(KEELING)", "COCOS PaisMapping(KEELING) ISLANDS"),
            PaisMapping(111, "ILHAS COOK", "COOK ISLANDS"),
            PaisMapping(112, "ILHAS DO MAR DE CORAL", "CORAL SEA ISLANDS"),
            PaisMapping(113, "ILHAS FALKLANDS PaisMapping(ILHAS MALVINAS)", "FALKLAND ISLANDS PaisMapping(ISLAS MALVINAS)"),
            PaisMapping(114, "ILHAS FEROE", "FAROE ISLANDS"),
            PaisMapping(115, "ILHAS GEÓRGIA DO SUL E SANDWICH DO SUL", "SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS"),
            PaisMapping(116, "ILHAS MARIANAS DO NORTE", "NORTHERN MARIANA ISLANDS"),
            PaisMapping(117, "ILHAS MARSHALL", "MARSHALL ISLANDS"),
            PaisMapping(118, "ILHAS PARACEL", "PARACEL ISLANDS"),
            PaisMapping(119, "ILHAS PITCAIRN", "PITCAIRN ISLANDS"),
            PaisMapping(120, "ILHAS SALOMÃO", "SOLOMON ISLANDS"),
            PaisMapping(121, "ILHAS SPRATLY", "SPRATLY ISLANDS"),
            PaisMapping(122, "ILHAS VIRGENS AMERICANAS", "UNITED STATES VIRGIN ISLANDS"),
            PaisMapping(123, "ILHAS VIRGENS BRITÂNICAS", "BRITISH VIRGIN ISLANDS"),
            PaisMapping(124, "ÍNDIA", "INDIA"),
            PaisMapping(125, "INDONÉSIA", "INDONESIA"),
            PaisMapping(126, "IRÃO", "IRAN"),
            PaisMapping(127, "IRAQUE", "IRAQ"),
            PaisMapping(128, "IRLANDA", "IRELAND"),
            PaisMapping(129, "ISLÂNDIA", "ICELAND"),
            PaisMapping(130, "ISRAEL", "ISRAEL"),
            PaisMapping(131, "ITÁLIA", "ITALY"),
            PaisMapping(132, "JAMAICA", "JAMAICA"),
            PaisMapping(133, "JAN MAYEN", "JAN MAYEN"),
            PaisMapping(134, "JAPÃO", "JAPAN"),
            PaisMapping(135, "JERSEY", "JERSEY"),
            PaisMapping(136, "JIBUTI", "DJIBOUTI"),
            PaisMapping(137, "JORDÂNIA", "JORDAN"),
            PaisMapping(138, "KIRIBATI", "KIRIBATI"),
            PaisMapping(139, "KOWEIT", "KUWAIT"),
            PaisMapping(140, "LAOS", "LAOS"),
            PaisMapping(141, "LESOTO", "LESOTHO"),
            PaisMapping(142, "LETÓNIA", "LATVIA"),
            PaisMapping(143, "LÍBANO", "LEBANON"),
            PaisMapping(144, "LIBÉRIA", "LIBERIA"),
            PaisMapping(145, "LÍBIA", "LIBYAN ARAB JAMAHIRIYA"),
            PaisMapping(146, "LISTENSTAINE", "LIECHTENSTEIN"),
            PaisMapping(147, "LITUÂNIA", "LITHUANIA"),
            PaisMapping(148, "LUXEMBURGO", "LUXEMBOURG"),
            PaisMapping(149, "MACAU", "MACAO"),
            PaisMapping(150, "MACEDÓNIA", "MACEDONIA"),
            PaisMapping(151, "MADAGÁSCAR", "MADAGASCAR"),
            PaisMapping(152, "MALÁSIA", "MALAYSIA"),
            PaisMapping(153, "MALAVI", "MALAWI"),
            PaisMapping(154, "MALDIVAS", "MALDIVES"),
            PaisMapping(155, "MALI", "MALI"),
            PaisMapping(156, "MALTA", "MALTA"),
            PaisMapping(157, "MARROCOS", "MOROCCO"),
            PaisMapping(158, "MARTINICA", "MARTINIQUE"),
            PaisMapping(159, "MAURÍCIA", "MAURITIUS"),
            PaisMapping(160, "MAURITÂNIA", "MAURITANIA"),
            PaisMapping(161, "MAYOTTE", "MAYOTTE"),
            PaisMapping(162, "MÉXICO", "MEXICO"),
            PaisMapping(163, "MIANMAR", "MYANMAR BURMA"),
            PaisMapping(164, "MICRONÉSIA", "MICRONESIA"),
            PaisMapping(165, "MOÇAMBIQUE", "MOZAMBIQUE"),
            PaisMapping(166, "MOLDÁVIA", "MOLDOVA"),
            PaisMapping(167, "MÓNACO", "MONACO"),
            PaisMapping(168, "MONGÓLIA", "MONGOLIA"),
            PaisMapping(169, "MONTENEGRO", "MONTENEGRO"),
            PaisMapping(170, "MONTSERRAT", "MONTSERRAT"),
            PaisMapping(171, "NAMÍBIA", "NAMIBIA"),
            PaisMapping(172, "NAURU", "NAURU"),
            PaisMapping(173, "NEPAL", "NEPAL"),
            PaisMapping(174, "NICARÁGUA", "NICARAGUA"),
            PaisMapping(175, "NÍGER", "NIGER"),
            PaisMapping(176, "NIGÉRIA", "NIGERIA"),
            PaisMapping(177, "NIUE", "NIUE"),
            PaisMapping(178, "NORUEGA", "NORWAY"),
            PaisMapping(179, "NOVA CALEDÓNIA", "NEW CALEDONIA"),
            PaisMapping(180, "NOVA ZELÂNDIA", "NEW ZEALAND"),
            PaisMapping(181, "OMÃ", "OMAN"),
            PaisMapping(182, "PAÍSES BAIXOS", "NETHERLANDS"),
            PaisMapping(183, "PALAU", "PALAU"),
            PaisMapping(184, "PALESTINA", "PALESTINE"),
            PaisMapping(185, "PANAMÁ", "PANAMA"),
            PaisMapping(186, "PAPUÁSIA-NOVA GUINÉ", "PAPUA NEW GUINEA"),
            PaisMapping(187, "PAQUISTÃO", "PAKISTAN"),
            PaisMapping(188, "PARAGUAI", "PARAGUAY"),
            PaisMapping(189, "PERU", "PERU"),
            PaisMapping(190, "POLINÉSIA FRANCESA", "FRENCH POLYNESIA"),
            PaisMapping(191, "POLÓNIA", "POLAND"),
            PaisMapping(192, "PORTO RICO", "PUERTO RICO"),
            PaisMapping(193, "PORTUGAL", "PORTUGAL"),
            PaisMapping(194, "QUÉNIA", "KENYA"),
            PaisMapping(195, "QUIRGUIZISTÃO", "KYRGYZSTAN"),
            PaisMapping(196, "REINO UNIDO", "UNITED KINGDOM"),
            PaisMapping(197, "REPÚBLICA CHECA", "CZECH REPUBLIC"),
            PaisMapping(198, "REPÚBLICA DOMINICANA", "DOMINICAN REPUBLIC"),
            PaisMapping(199, "ROMÉNIA", "ROMANIA"),
            PaisMapping(200, "RUANDA", "RWANDA"),
            PaisMapping(201, "RÚSSIA", "RUSSIAN FEDERATION"),
            PaisMapping(202, "SAHARA OCCIDENTAL", "WESTERN SAHARA"),
            PaisMapping(203, "SALVADOR", "EL SALVADOR"),
            PaisMapping(204, "SAMOA", "SAMOA"),
            PaisMapping(205, "SANTA HELENA", "SAINT HELENA"),
            PaisMapping(206, "SANTA LÚCIA", "SAINT LUCIA"),
            PaisMapping(207, "SANTA SÉ", "HOLY SEE"),
            PaisMapping(208, "SÃO CRISTÓVÃO E NEVES", "SAINT KITTS AND NEVIS"),
            PaisMapping(209, "SÃO MARINO", "SAN MARINO"),
            PaisMapping(210, "SÃO PEDRO E MIQUELÃO", "SAINT PIERRE AND MIQUELON"),
            PaisMapping(211, "SÃO TOMÉ E PRÍNCIPE", "SAO TOME AND PRINCIPE"),
            PaisMapping(212, "SÃO VICENTE E GRANADINAS", "SAINT VINCENT AND THE GRENADINES"),
            PaisMapping(213, "SEICHELES", "SEYCHELLES"),
            PaisMapping(214, "SENEGAL", "SENEGAL"),
            PaisMapping(215, "SERRA LEOA", "SIERRA LEONE"),
            PaisMapping(216, "SÉRVIA", "SERBIA"),
            PaisMapping(217, "SINGAPURA", "SINGAPORE"),
            PaisMapping(218, "SÍRIA", "SYRIA"),
            PaisMapping(219, "SOMÁLIA", "SOMALIA"),
            PaisMapping(220, "SRI LANCA", "SRI LANKA"),
            PaisMapping(221, "SUAZILÂNDIA", "SWAZILAND"),
            PaisMapping(222, "SUDÃO", "SUDAN"),
            PaisMapping(223, "SUÉCIA", "SWEDEN"),
            PaisMapping(224, "SUÍÇA", "SWITZERLAND"),
            PaisMapping(225, "SURINAME", "SURINAME"),
            PaisMapping(226, "SVALBARD", "SVALBARD"),
            PaisMapping(227, "TAILÂNDIA", "THAILAND"),
            PaisMapping(228, "TAIWAN", "TAIWAN"),
            PaisMapping(229, "TAJIQUISTÃO", "TAJIKISTAN"),
            PaisMapping(230, "TANZÂNIA", "TANZANIA"),
            PaisMapping(231, "TERRITÓRIO BRITÂNICO DO OCEANO ÍNDICO", "BRITISH INDIAN OCEAN TERRITORY"),
            PaisMapping(232, "TERRITÓRIO DAS ILHAS HEARD E MCDONALD", "HEARD ISLAND AND MCDONALD ISLANDS"),
            PaisMapping(233, "TIMOR-LESTE", "TIMOR-LESTE"),
            PaisMapping(234, "TOGO", "TOGO"),
            PaisMapping(235, "TOKELAU", "TOKELAU"),
            PaisMapping(236, "TONGA", "TONGA"),
            PaisMapping(237, "TRINDADE E TOBAGO", "TRINIDAD AND TOBAGO"),
            PaisMapping(238, "TUNÍSIA", "TUNISIA"),
            PaisMapping(239, "TURKS E CAICOS", "TURKS AND CAICOS ISLANDS"),
            PaisMapping(240, "TURQUEMENISTÃO", "TURKMENISTAN"),
            PaisMapping(241, "TURQUIA", "TURKEY"),
            PaisMapping(242, "TUVALU", "TUVALU"),
            PaisMapping(243, "UCRÂNIA", "UKRAINE"),
            PaisMapping(244, "UGANDA", "UGANDA"),
            PaisMapping(245, "URUGUAI", "URUGUAY"),
            PaisMapping(246, "USBEQUISTÃO", "UZBEKISTAN"),
            PaisMapping(247, "VANUATU", "VANUATU"),
            PaisMapping(248, "VENEZUELA", "VENEZUELA"),
            PaisMapping(249, "VIETNAME", "VIETNAM"),
            PaisMapping(250, "WALLIS E FUTUNA", "WALLIS AND FUTUNA"),
            PaisMapping(251, "ZÂMBIA", "ZAMBIA"),
            PaisMapping(252, "ZIMBABUÉ", "ZIMBABWE")
        )
        paisMappingDAO.populatePaisesMapping(paises)
    }

    override suspend fun getAllTemplatesTask() = templateDAO.getAllTemplates()

    override suspend fun getAllFilmesReplaceTask() = filmeReplaceDAO.getAllFilmesReplace()

    override suspend fun getAllConfiguracoesTask() = configuracoesDAO.getAllConfiguracoes()

    override suspend fun getConfiguracoesForUserTask(email: String) = configuracoesDAO
        .getConfiguracoesForUser(email)

    override suspend fun getPaisPortuguesDBService(country: String): String {
        return paisMappingDAO.getPaisPortugues(country)
    }

    override suspend fun testIsEmptyDBService(): Int {
        return paisMappingDAO.testIsEmpty()
    }


    override suspend fun updateConfiguracoesTask(configuracoes: Configuracoes): Configuracoes {
        configuracoesDAO.updateConfiguracoes(configuracoes)
        return configuracoesDAO.getConfiguracoesForUser(configuracoes.email)
    }

}


lateinit var dbApp: AppDataBase
lateinit var dbRepository: DBRepository
