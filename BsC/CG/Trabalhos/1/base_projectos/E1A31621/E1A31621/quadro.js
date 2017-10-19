function Ramarelas(c) { //Rectas amarelas
    c.fillStyle = "#DCAB00"; //#DCAB00 Cor Amarela
    c.fillRect(28, 66, 48, 235);

    c.fillRect(83, 80, 25, 84);

    c.fillRect(232, 129, 229, 35);

    //Rectangulo esquisito
    c.beginPath();
    c.moveTo(310, 189);
    c.lineTo(477, 294);
    c.lineTo(459, 315);
    c.lineTo(293, 212);
    c.closePath();
    c.strokeStyle = "#DCAB00";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    //Triangulo de cima
    c.beginPath();
    c.moveTo(124, 60);
    c.lineTo(124, 164);
    c.lineTo(129, 164);
    c.lineTo(129, 131);
    c.lineTo(166, 131);
    c.closePath();
    c.strokeStyle = "#DCAB00";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(180, 163);
    c.lineTo(190, 181);
    c.lineTo(194, 181);
    c.lineTo(194, 186);
    c.lineTo(208, 186);
    c.lineTo(194, 163);
    c.closePath();
    c.strokeStyle = "#DCAB00";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.fillRect(176, 190, 19, 3);

    //Triangulo de baixo
    c.fillRect(126, 211, 14, 7);

    c.beginPath();
    c.moveTo(140, 247);
    c.lineTo(140, 302);
    c.lineTo(205, 302);
    c.lineTo(175, 266);
    c.lineTo(155, 244);
    c.lineTo(159, 239);
    c.lineTo(153, 231);
    c.closePath();
    c.strokeStyle = "#DCAB00";
    c.lineWidth = 1;
    c.stroke();
    c.fill();
}

function Rpretas(c) { // Rectas pretas
    c.fillStyle = "#0E0C12";
    c.fillRect(0, 164, 31, 48);

    //Forma esquisita a esquerda
    c.beginPath();
    c.moveTo(44, 164);
    c.lineTo(66, 206);
    c.lineTo(57, 212);
    c.lineTo(140, 211);
    c.lineTo(140, 173);
    c.lineTo(170, 140);
    c.lineTo(170, 211);
    c.lineTo(176, 211);
    c.lineTo(176, 187);
    c.lineTo(195, 187);
    c.lineTo(195, 197);
    c.lineTo(235, 197);
    c.lineTo(235, 187);
    c.lineTo(195, 187);
    c.lineTo(195, 182);
    c.lineTo(176, 182);
    c.lineTo(176, 163);
    c.lineTo(196, 163);
    c.lineTo(196, 114);
    c.lineTo(177, 114);
    c.lineTo(177, 130);
    c.lineTo(129, 130);
    c.lineTo(129, 164);
    c.lineTo(125, 164);
    c.lineTo(125, 198);
    c.lineTo(103, 164);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    //Forma esquisita a direita
    c.beginPath();
    c.moveTo(321, 144);
    c.lineTo(324, 186);
    c.lineTo(356, 207);
    c.lineTo(349, 214);
    c.lineTo(375, 232);
    c.lineTo(368, 238);
    c.lineTo(439, 282);
    c.lineTo(446, 275);
    c.lineTo(417, 256);
    c.lineTo(422, 252);
    c.lineTo(384, 227);
    c.lineTo(386, 225);
    c.lineTo(427, 250);
    c.lineTo(432, 246);
    c.lineTo(470, 270);
    c.lineTo(467, 276);
    c.lineTo(497, 294);
    c.lineTo(497, 144);
    c.lineTo(489, 144);
    c.lineTo(489, 116);
    c.lineTo(466, 116);
    c.lineTo(466, 143);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(72, 221);
    c.lineTo(41, 258);
    c.lineTo(72, 301);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(139, 342);
    c.lineTo(178, 342);
    c.lineTo(182, 348);
    c.lineTo(144, 348);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    //lozangulos
    c.beginPath();
    c.moveTo(223, 206);
    c.lineTo(213, 219);
    c.lineTo(217, 223);
    c.lineTo(226, 210);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(224, 245);
    c.lineTo(233, 257);
    c.lineTo(242, 245);
    c.lineTo(233, 232);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 3;
    c.stroke();

    c.beginPath();
    c.moveTo(248, 240);
    c.lineTo(263, 260);
    c.lineTo(278, 240);
    c.lineTo(263, 219);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 4.5;
    c.stroke();

    c.beginPath();
    c.moveTo(242, 129);
    c.lineTo(235, 142);
    c.lineTo(242, 156);
    c.lineTo(249, 142);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 3;
    c.stroke();

}

function Razuis(c) { // Rectas azuis
    c.fillStyle = "#3384D2";

    c.fillRect(0, 168, 23, 8);

    c.beginPath();
    c.moveTo(28.5, 105);
    c.lineTo(28.5, 110);
    c.lineTo(54, 162);
    c.lineTo(54, 105);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(31, 139);
    c.lineTo(32, 239);
    c.lineTo(56, 239);
    c.lineTo(41, 223);
    c.lineTo(66, 206);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(75, 212.5);
    c.lineTo(75, 287);
    c.lineTo(109, 287);
    c.lineTo(88, 242);
    c.lineTo(112, 242);
    c.lineTo(112, 212.5);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    //tinha de ser preta aqui
    c.beginPath();
    c.moveTo(103, 214);
    c.lineTo(103, 226);
    c.lineTo(112, 240);
    c.lineTo(112, 228);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fillStyle = "#0E0C12";
    c.fill();

    //devolta ao azul
    c.fillStyle = "#3384D2";

    c.beginPath();
    c.moveTo(0, 225);
    c.lineTo(0, 273);
    c.lineTo(56, 338);
    c.lineTo(100, 338);
    c.lineTo(70, 302);
    c.lineTo(33, 302);
    c.lineTo(33, 262);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(96, 110);
    c.lineTo(96, 158);
    c.lineTo(99, 163);
    c.lineTo(103, 163);
    c.lineTo(124, 199);
    c.lineTo(124, 163);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.fillRect(154, 49, 16, 63);

    c.beginPath();
    c.moveTo(140, 173);
    c.lineTo(140, 247);
    c.lineTo(170, 210);
    c.lineTo(170, 141);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(162, 224);
    c.lineTo(198, 267);
    c.lineTo(213, 255);
    c.lineTo(178, 215);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    //outro lozangulo preto
    c.beginPath();
    c.moveTo(197, 222);
    c.lineTo(187, 235);
    c.lineTo(197, 249);
    c.lineTo(207, 235);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fillStyle = "#0E0C12";
    c.fill();

    c.fillStyle = "#3384D2";

    c.beginPath();
    c.moveTo(181, 135);
    c.lineTo(185, 125);
    c.lineTo(190, 135);
    c.lineTo(185, 144);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 2;
    c.stroke();

    c.beginPath();
    c.moveTo(272, 177);
    c.lineTo(285, 193);
    c.lineTo(272, 210);
    c.lineTo(260, 193);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(405, 144);
    c.lineTo(413, 136);
    c.lineTo(421, 144);
    c.lineTo(413, 152);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 4;
    c.stroke();

    c.beginPath();
    c.moveTo(259, 276);
    c.lineTo(250, 287);
    c.lineTo(259, 300);
    c.lineTo(267, 287);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 1;
    c.stroke();

    c.fillRect(124, 337, 42, 2);

    c.beginPath();
    c.moveTo(426, 251);
    c.lineTo(466, 277);
    c.lineTo(471, 271);
    c.lineTo(432, 246);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    //azul mais claro
    c.beginPath();
    c.moveTo(41, 223);
    c.lineTo(56, 239);
    c.lineTo(75, 217);
    c.lineTo(75, 212.5);
    c.lineTo(57, 212.5);
    c.closePath();
    c.strokeStyle = "#67A4EA";
    c.lineWidth = 1;
    c.stroke();
    c.fillStyle = "#67A4EA";
    c.fill();

    c.fillStyle = "#3384D2";

    c.fillRect(0, 295, 7, 54);

    c.beginPath();
    c.moveTo(146, 123);
    c.lineTo(146, 142);
    c.lineTo(148, 146);
    c.lineTo(148, 123);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 1;
    c.stroke();
    c.fill();
}

function Rvermelhas(c) { //Rectas vermelhas
    c.fillStyle = "#A6211D";

    c.fillRect(121, 218, 20, 89);

    c.beginPath();
    c.moveTo(33, 251);
    c.lineTo(33, 302);
    c.lineTo(70, 302);
    c.closePath();
    c.strokeStyle = "#A6211D";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(93, 212);
    c.lineTo(93, 243);
    c.lineTo(108, 274);
    c.lineTo(108, 241);
    c.closePath();
    c.strokeStyle = "#A6211D";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(173, 238);
    c.lineTo(166, 248);
    c.lineTo(178, 261);
    c.lineTo(175, 266);
    c.lineTo(188, 280);
    c.lineTo(198, 267);
    c.closePath();
    c.strokeStyle = "#A6211D";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(217, 223);
    c.lineTo(224, 232);
    c.lineTo(233, 220);
    c.lineTo(226, 210);
    c.closePath();
    c.strokeStyle = "#A6211D";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(159, 153);
    c.lineTo(159, 223.5);
    c.lineTo(165, 216);
    c.lineTo(165, 146);
    c.closePath();
    c.strokeStyle = "#A6211D";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(92, 104);
    c.lineTo(92, 153);
    c.lineTo(96, 158);
    c.lineTo(96, 111);
    c.closePath();
    c.strokeStyle = "#A6211D";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(142, 123);
    c.lineTo(142, 136);
    c.lineTo(146, 143);
    c.lineTo(146, 123);
    c.closePath();
    c.strokeStyle = "#A6211D";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.fillRect(149, 124, 2, 27);

    c.fillRect(165, 65, 2, 47);

    c.fillRect(196, 108, 10, 55.5);

    c.beginPath();
    c.moveTo(327, 270);
    c.lineTo(356, 292);
    c.lineTo(389, 270);
    c.lineTo(356, 248);
    c.closePath();
    c.strokeStyle = "#A6211D";
    c.lineWidth = 7;
    c.stroke();

    //preta cenas
    c.fillStyle = "#0E0C12";

    c.beginPath();
    c.moveTo(159, 240);
    c.lineTo(142, 263);
    c.lineTo(161, 285);
    c.lineTo(158, 279);
    c.lineTo(146, 263);
    c.lineTo(158, 247);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(159, 240);
    c.lineTo(177, 262);
    c.lineTo(161, 285);
    c.lineTo(158, 279);
    c.lineTo(170, 261);
    c.lineTo(158, 247);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(205, 266);
    c.lineTo(209, 266);
    c.lineTo(218, 255);
    c.lineTo(227, 266);
    c.lineTo(230, 266);
    c.lineTo(218, 248);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(205, 266);
    c.lineTo(218, 284);
    c.lineTo(230, 266);
    c.lineTo(227, 266);
    c.lineTo(218, 279);
    c.lineTo(209, 266);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    //back to red
    c.fillStyle = "#A6211D";

    c.beginPath();
    c.moveTo(426, 251);
    c.lineTo(417, 256);
    c.lineTo(446, 275);
    c.lineTo(444, 278);
    c.lineTo(456, 286);
    c.lineTo(466, 277);
    c.closePath();
    c.strokeStyle = "#A6211D";
    c.lineWidth = 1;
    c.stroke();
    c.fill();
}

function Rbrancas(c) { // Rectas brancas
    c.fillStyle = "#CED1D2";

    c.beginPath();
    c.moveTo(99, 115);
    c.lineTo(99, 163);
    c.lineTo(103, 163);
    c.lineTo(103, 122);
    c.closePath();
    c.strokeStyle = "#CED1D2";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.fillRect(152, 130, 2, 23);
    c.fillRect(163, 65, 2, 49);

    c.fillStyle = "#DCAB00";
    c.beginPath();
    c.moveTo(140, 123);
    c.lineTo(140, 134);
    c.lineTo(142, 137);
    c.lineTo(142, 123);
    c.closePath();
    c.strokeStyle = "#DCAB00";
    c.lineWidth = 1;
    c.stroke();
    c.fill();
}

function Camarelas(c) {// Curvas amarelas
    c.fillStyle = "#DCAB00";

    c.beginPath();
    c.moveTo(299, 113);
    c.quadraticCurveTo(277, 149, 299, 189);
    c.quadraticCurveTo(320, 149, 299, 113);
    c.closePath();
    c.strokeStyle = "#DCAB00";
    c.lineWidth = 3;
    c.stroke();

    c.beginPath();
    c.moveTo(281, 63);
    c.quadraticCurveTo(269, 88, 281, 113);
    c.quadraticCurveTo(293, 88, 281, 63);
    c.closePath();
    c.strokeStyle = "#DCAB00";
    c.lineWidth = 3;
    c.stroke();

    c.beginPath();
    c.moveTo(242, 90);
    c.quadraticCurveTo(238, 102, 227, 113);
    c.quadraticCurveTo(201, 142, 227, 172);
    c.quadraticCurveTo(238, 179, 242, 195);
    c.quadraticCurveTo(247, 179, 257, 172);
    c.quadraticCurveTo(284, 142, 257, 113);
    c.quadraticCurveTo(247, 102, 242, 90);
    c.closePath();
    c.strokeStyle = "#DCAB00";
    c.lineWidth = 5;
    c.stroke();

    c.beginPath();
    c.moveTo(338, 56);
    c.quadraticCurveTo(326, 86, 338, 115);
    c.quadraticCurveTo(348, 124, 358, 115);
    c.quadraticCurveTo(371, 86, 357, 56);
    c.quadraticCurveTo(348, 48, 338, 56);
    c.closePath();
    c.strokeStyle = "#DCAB00";
    c.lineWidth = 10;
    c.stroke();

    //insert preta aqui
    c.beginPath();
    c.moveTo(369, 100);
    c.quadraticCurveTo(366, 111, 359, 120);
    c.lineTo(431, 120);
    c.lineTo(431, 100);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fillStyle = "#0E0C12";
    c.fill();

    c.fillStyle = "#DCAB00";
}

function Cpretas(c) { // Curvas pretas
    c.fillStyle = "#0E0C12";

    c.beginPath();
    c.moveTo(234, 121);
    c.quadraticCurveTo(214, 142, 234, 164);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 1;
    c.stroke();
    c.fill();

    c.beginPath();
    c.moveTo(299, 124);
    c.quadraticCurveTo(311, 150, 299, 178);
    c.quadraticCurveTo(286, 149, 299, 124);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 2;
    c.stroke();
}

function Cazuis(c) { //Curvas azuis
    c.fillStyle = "#3384D2";

    c.beginPath();
    c.moveTo(242, 96);
    c.quadraticCurveTo(238, 105, 231, 112);
    c.quadraticCurveTo(201, 142, 231, 173);
    c.quadraticCurveTo(238, 179, 242, 188);
    c.quadraticCurveTo(247, 179, 253, 173);
    c.quadraticCurveTo(284, 142, 253, 112);
    c.quadraticCurveTo(247, 105, 242, 96);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 2;
    c.stroke();

    c.beginPath();
    c.moveTo(242, 102);
    c.quadraticCurveTo(238, 110, 233, 114);
    c.quadraticCurveTo(204, 142, 233, 171);
    c.quadraticCurveTo(238, 176, 242, 183);
    c.quadraticCurveTo(246, 176, 251, 171);
    c.quadraticCurveTo(281, 142, 251, 114);
    c.quadraticCurveTo(247, 110, 242, 102);
    c.closePath();
    c.strokeStyle = "#65A4E3";
    c.lineWidth = 4;
    c.stroke();

    c.beginPath();
    c.moveTo(299, 119);
    c.quadraticCurveTo(282, 149, 299, 183);
    c.quadraticCurveTo(316, 149, 299, 119);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 2;
    c.stroke();


    c.beginPath();
    c.moveTo(281, 54);
    c.quadraticCurveTo(259, 88, 281, 121);
    c.quadraticCurveTo(303, 88, 281, 54);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 3;
    c.stroke();

    c.beginPath();
    c.moveTo(386, 64);
    c.quadraticCurveTo(369, 91, 386, 124);
    c.quadraticCurveTo(405, 91, 386, 64);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 4;
    c.stroke();

    c.beginPath();
    c.moveTo(343, 59);
    c.quadraticCurveTo(333, 85, 343, 112);
    c.quadraticCurveTo(349, 116, 354, 112);
    c.quadraticCurveTo(363, 86, 354, 59);
    c.quadraticCurveTo(348, 56, 343, 59);
    c.closePath();
    c.strokeStyle = "#3384D2";
    c.lineWidth = 3;
    c.stroke();
}

function Cvermelhas(c) { //Curvas vermelhas
    c.fillStyle = "#A6211D";

    c.beginPath();
    c.moveTo(242, 109);
    c.quadraticCurveTo(238, 115, 232, 120);
    c.quadraticCurveTo(213, 142, 231, 163);
    c.quadraticCurveTo(236, 167, 242, 176);
    c.quadraticCurveTo(248, 167, 252, 163);
    c.quadraticCurveTo(273, 142, 252, 120);
    c.quadraticCurveTo(246, 115, 242, 109);
    c.closePath();
    c.strokeStyle = "#A6211D";
    c.lineWidth = 4;
    c.stroke();

    //yea you guess it, preta cenas
    c.beginPath();
    c.moveTo(282, 128);
    c.lineTo(272.5, 147);
    c.lineTo(282, 165);
    c.lineTo(291.5, 147);
    c.closePath();
    c.strokeStyle = "#0E0C12";
    c.lineWidth = 3;
    c.stroke();

    //de volta ao vermelho
    c.beginPath();
    c.moveTo(282, 121);
    c.lineTo(273, 138);
    c.quadraticCurveTo(267, 147, 273, 154);
    c.lineTo(282, 171);
    c.lineTo(291, 154);
    c.quadraticCurveTo(297, 147, 291, 140);
    c.closePath();
    c.strokeStyle = "#A6211D";
    c.lineWidth = 4;
    c.stroke();

    c.fillRect(254, 164, 8, 32);
    c.fillRect(312, 97, 5, 54);
}

function main() { //chamamento de funcoes e cenas
    var cv = document.getElementById("MyCanvas");
    var c = cv.getContext("2d");

    c.fillStyle = "#C8C6CD"; //#C8C6CD Cor de fundo Cinzenta
    c.fillRect(0, 0, 500, 349);

    Ramarelas(c);
    Rpretas(c);
    Razuis(c);
    Rvermelhas(c);
    Rbrancas(c);
    Camarelas(c);
    Cpretas(c);
    Cazuis(c);
    Cvermelhas(c);
}