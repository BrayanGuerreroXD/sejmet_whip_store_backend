-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-12-2022 a las 15:16:48
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sejmet_whip_store`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
                            `id` int(11) NOT NULL,
                            `category_name` varchar(20) NOT NULL,
                            `category_description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id`, `category_name`, `category_description`) VALUES
                                                                           (1, 'Multi-Tail Whip', 'Whip with more than one tail'),
                                                                           (2, 'Uni-Tail Whip', 'Whip with a single tail');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category_id_seq`
--

CREATE TABLE `category_id_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `category_id_seq`
--

INSERT INTO `category_id_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comment`
--

CREATE TABLE `comment` (
                           `id` int(11) NOT NULL,
                           `sale_product_id` int(11) NOT NULL,
                           `user_id` int(11) NOT NULL,
                           `str_comment` varchar(1000) NOT NULL,
                           `score` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `image`
--

CREATE TABLE `image` (
                         `id` int(11) NOT NULL,
                         `product_id` int(11) NOT NULL,
                         `image_name` varchar(100) NOT NULL,
                         `image_src` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `image`
--

INSERT INTO `image` (`id`, `product_id`, `image_name`, `image_src`) VALUES
                                                                        (1, 1, 'APHRODISIA LEATHER WHIP 1', '/assets/images/products_images/APHRODISIA LEATHER WHIP/APHRODISIA LEATHER WHIP 1.jpg'),
                                                                        (2, 1, 'APHRODISIA LEATHER WHIP 2', '/assets/images/products_images/APHRODISIA LEATHER WHIP/APHRODISIA LEATHER WHIP 2.jpg'),
                                                                        (3, 1, 'APHRODISIA LEATHER WHIP 3', '/assets/images/products_images/APHRODISIA LEATHER WHIP/APHRODISIA LEATHER WHIP 3.jpg'),
                                                                        (4, 2, 'SADOMASOCHISTIC PADDLE 1', '/assets/images/products_images/SADOMASOCHISTIC PADDLE/SADOMASOCHISTIC PADDLE 1.jpg'),
                                                                        (5, 2, 'SADOMASOCHISTIC PADDLE 2', '/assets/images/products_images/SADOMASOCHISTIC PADDLE/SADOMASOCHISTIC PADDLE 2.jpg'),
                                                                        (6, 2, 'SADOMASOCHISTIC PADDLE 3', '/assets/images/products_images/SADOMASOCHISTIC PADDLE/SADOMASOCHISTIC PADDLE 3.jpg'),
                                                                        (7, 2, 'SADOMASOCHISTIC PADDLE 4', '/assets/images/products_images/SADOMASOCHISTIC PADDLE/SADOMASOCHISTIC PADDLE 4.jpg'),
                                                                        (8, 3, 'SPADE WHIP 1', '/assets/images/products_images/SPADE WHIP/SPADE WHIP 1.jpg'),
                                                                        (9, 3, 'SPADE WHIP 2', '/assets/images/products_images/SPADE WHIP/SPADE WHIP 2.jpg'),
                                                                        (10, 3, 'SPADE WHIP 3', '/assets/images/products_images/SPADE WHIP/SPADE WHIP 3.jpg'),
                                                                        (11, 4, 'LUKE WHIP 1', '/assets/images/products_images/LUKE WHIP/LUKE WHIP 1.jpg'),
                                                                        (12, 4, 'LUKE WHIP 2', '/assets/images/products_images/LUKE WHIP/LUKE WHIP 2.jpg'),
                                                                        (13, 4, 'LUKE WHIP 3', '/assets/images/products_images/LUKE WHIP/LUKE WHIP 3.jpg'),
                                                                        (14, 5, 'LONG WHIP BLACK 1', '/assets/images/products_images/LONG WHIP BLACK/LONG WHIP BLACK 1.jpg'),
                                                                        (15, 5, 'LONG WHIP BLACK 2', '/assets/images/products_images/LONG WHIP BLACK/LONG WHIP BLACK 2.jpg'),
                                                                        (16, 6, 'AZÓTAME ADAM & EVE WHIP 1', '/assets/images/products_images/AZÓTAME ADAM & EVE WHIP/AZÓTAME ADAM & EVE WHIP 1.jpg'),
                                                                        (17, 6, 'AZÓTAME ADAM & EVE WHIP 2', '/assets/images/products_images/AZÓTAME ADAM & EVE WHIP/AZÓTAME ADAM & EVE WHIP 2.webp'),
                                                                        (18, 6, 'AZÓTAME ADAM & EVE WHIP 3', '/assets/images/products_images/AZÓTAME ADAM & EVE WHIP/AZÓTAME ADAM & EVE WHIP 3.webp'),
                                                                        (19, 7, 'KITTY POINTER WHIP 1', '/assets/images/products_images/KITTY POINTER WHIP/KITTY POINTER WHIP 1.jpg'),
                                                                        (20, 7, 'KITTY POINTER WHIP 2', '/assets/images/products_images/KITTY POINTER WHIP/KITTY POINTER WHIP 2.jpg'),
                                                                        (21, 8, 'KENT WHIP 1', '/assets/images/products_images/KENT WHIP/KENT WHIP 1.jpg'),
                                                                        (22, 8, 'KENT WHIP 2', '/assets/images/products_images/KENT WHIP/KENT WHIP 2.jpg'),
                                                                        (23, 8, 'KENT WHIP 3', '/assets/images/products_images/KENT WHIP/KENT WHIP 3.jpg'),
                                                                        (24, 9, 'SQUARED CROP BLACK 1', '/assets/images/products_images/SQUARED CROP BLACK/SQUARED CROP BLACK 1.jpg'),
                                                                        (25, 9, 'SQUARED CROP BLACK 2', '/assets/images/products_images/SQUARED CROP BLACK/SQUARED CROP BLACK 2.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `image_id_seq`
--

CREATE TABLE `image_id_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `image_id_seq`
--

INSERT INTO `image_id_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
                           `id` int(11) NOT NULL,
                           `category_id` int(11) NOT NULL,
                           `product_name` varchar(100) NOT NULL,
                           `visibility` int(10) NOT NULL,
                           `sale_price` int(10) NOT NULL,
                           `stock` int(10) NOT NULL,
                           `product_description` varchar(1000) NOT NULL,
                           `product_characteristics` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id`, `category_id`, `product_name`, `visibility`, `sale_price`, `stock`, `product_description`, `product_characteristics`) VALUES
                                                                                                                                                       (1, 1, 'APHRODISIA LEATHER WHIP', 0, 35000, 10, 'Nine intertwined leather tails hang from a strong handle. Every time you touch his skin with it, you will see how your kind servant understands your instructions at the first time', '- Multi-Tail whip\r\n- Black and red'),
                                                                                                                                                       (2, 2, 'SADOMASOCHISTIC PADDLE', 0, 45000, 20, 'Design of exciting sound when touching your body, soft contact with your skin. How do you want to mark your lover?', '- Uni-Tail whip\r\n- Black and red\r\n- Little heart'),
                                                                                                                                                       (3, 2, 'SPADE WHIP', 0, 35000, 10, 'Dare to change the monotony of the bedroom and enjoy rough sex. It can be used for flirting between partners, such as spanking or hip touching', '- Uni-Tail whip\r\n- Only black color'),
                                                                                                                                                       (4, 1, 'LUKE WHIP', 0, 23900, 5, 'The Luke Whip has a beautiful animal print design on its handle with a tip surrounded by synthetic leather bangs for a super satisfying climax in the sexual act', '- Multi-Tail whip\r\n- Black and pink'),
                                                                                                                                                       (5, 1, 'LONG WHIP BLACK', 0, 47000, 10, 'Extra large whip in synthetic leather intertwined with braid shape and straps at the tip', '- Multi-Tail long whip\r\n- Only black'),
                                                                                                                                                       (6, 2, 'AZÓTAME ADAM & EVE WHIP', 0, 401900, 20, 'You are going to get intimate with your partner in a daring way, bordering on the dark side of BDSM, but in an almost innocent way, thanks to the design of our Adam & Eve Black Whip', '- Uni-Tail whip\r\n- Multifunctional vibrator\r\n- Only black'),
                                                                                                                                                       (7, 2, 'KITTY POINTER WHIP', 0, 48900, 10, 'With this whip with leather handle in the shape of a kitten, you will whip your partner with strong and funny spankings, bearing in mind that the intensity with which it is applied will depend on his or her tast', '- Uni-Tail whip\r\n- Only black\r\n- Little cat'),
                                                                                                                                                       (8, 1, 'KENT WHIP', 0, 37900, 10, 'Satisfy what your partner is asking for with this ostentatious Kent Whip, ideal to get out of the routine and give pleasure in a unique way', '- Multi-Tail whip\r\n- Only black'),
                                                                                                                                                       (9, 2, 'SQUARED CROP BLACK', 0, 40000, 10, 'Rigid whip with small studs on the tip for spanking or spanking practices', '- Uni-Tail whip\r\n- Only black');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product_id_seq`
--

CREATE TABLE `product_id_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `product_id_seq`
--

INSERT INTO `product_id_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `question`
--

CREATE TABLE `question` (
                            `id` int(11) NOT NULL,
                            `product_id` int(11) NOT NULL,
                            `user_id` int(11) NOT NULL,
                            `str_question` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `question_id_seq`
--

CREATE TABLE `question_id_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `question_id_seq`
--

INSERT INTO `question_id_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
                        `id` int(11) NOT NULL,
                        `role_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `role_name`) VALUES
                                           (1, 'admin'),
                                           (2, 'client');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role_id_seq`
--

CREATE TABLE `role_id_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `role_id_seq`
--

INSERT INTO `role_id_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sale`
--

CREATE TABLE `sale` (
                        `id` int(11) NOT NULL,
                        `user_id` int(11) NOT NULL,
                        `sale_date` date NOT NULL,
                        `delivery_date` date NOT NULL,
                        `total_price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sale`
--

INSERT INTO `sale` (`id`, `user_id`, `sale_date`, `delivery_date`, `total_price`) VALUES
    (1, 2, '2022-11-15', '2022-12-02', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sale_id_seq`
--

CREATE TABLE `sale_id_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sale_id_seq`
--

INSERT INTO `sale_id_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sale_product`
--

CREATE TABLE `sale_product` (
                                `id` int(11) NOT NULL,
                                `sale_id` int(11) NOT NULL,
                                `product_id` int(11) NOT NULL,
                                `product_amount` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sale_product_id_seq`
--

CREATE TABLE `sale_product_id_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sale_product_id_seq`
--

INSERT INTO `sale_product_id_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `shopping_cart`
--

CREATE TABLE `shopping_cart` (
                                 `id` int(11) NOT NULL,
                                 `user_id` int(11) NOT NULL,
                                 `amount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `shopping_cart`
--

INSERT INTO `shopping_cart` (`id`, `user_id`, `amount`) VALUES
                                                            (1, 2, 0),
                                                            (2, 4, 0),
                                                            (7, 5, 0),
                                                            (8, 6, 0),
                                                            (9, 8, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `shopping_cart_id_seq`
--

CREATE TABLE `shopping_cart_id_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `shopping_cart_id_seq`
--

INSERT INTO `shopping_cart_id_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `shopping_cart_product`
--

CREATE TABLE `shopping_cart_product` (
                                         `id` int(11) NOT NULL,
                                         `shopping_cart_id` int(11) NOT NULL,
                                         `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `shopping_cart_product`
--

INSERT INTO `shopping_cart_product` (`id`, `shopping_cart_id`, `product_id`) VALUES
                                                                                 (1, 1, 1),
                                                                                 (2, 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `shopping_cart_product_id_seq`
--

CREATE TABLE `shopping_cart_product_id_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `shopping_cart_product_id_seq`
--

INSERT INTO `shopping_cart_product_id_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
                        `id` int(11) NOT NULL,
                        `role_id` int(11) NOT NULL,
                        `user_name` varchar(30) NOT NULL,
                        `type_identity_card` varchar(10) NOT NULL,
                        `identity_card_number` int(20) NOT NULL,
                        `email` varchar(50) NOT NULL,
                        `password` varchar(20) NOT NULL,
                        `address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `role_id`, `user_name`, `type_identity_card`, `identity_card_number`, `email`, `password`, `address`) VALUES
                                                                                                                                    (1, 1, 'Brayan Guerrero', 'c.c.', 1005025955, 'bg7047653@gmail.com', 'brayan123', 'casita de Brayan'),
                                                                                                                                    (2, 2, 'Carlos Rene', 'c.c.', 123456789, 'carlosreneas@ufps.edu.co', 'rene123', 'casita de Rene'),
                                                                                                                                    (3, 1, 'Jesus', 'c.c.', 123456789, 'jesusmanuelcp@ufps.edu.co', 'jesus123', 'casita de jesus'),
                                                                                                                                    (4, 2, 'Camilo Daza', 'c.c.', 1234567890, 'camilodaza@gmail.com', 'camilo123', 'Casita de Camilo'),
                                                                                                                                    (5, 2, 'Gustavo Petro', 'c.c.', 1234567890, 'gustavopetro@gmail.com', 'gustavo123', 'Casa de Nariño'),
                                                                                                                                    (6, 2, 'Alvaro Uribe', 'c.c.', 1234567890, 'alvarouribe@gmail.com', 'alvaro123', 'El uberrimo'),
                                                                                                                                    (8, 2, 'JBalvin', 'c.c.', 1234567890, 'jbalvin@gmail.com', 'jbalvin123', 'Casita de JBalvin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_id_seq`
--

CREATE TABLE `user_id_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user_id_seq`
--

INSERT INTO `user_id_seq` (`next_val`) VALUES
    (5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
    ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comment`
--
ALTER TABLE `comment`
    ADD PRIMARY KEY (`id`),
  ADD KEY `productId` (`sale_product_id`),
  ADD KEY `userId` (`user_id`);

--
-- Indices de la tabla `image`
--
ALTER TABLE `image`
    ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
    ADD PRIMARY KEY (`id`),
  ADD KEY `idCategory` (`category_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indices de la tabla `question`
--
ALTER TABLE `question`
    ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
    ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `sale`
--
ALTER TABLE `sale`
    ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`user_id`);

--
-- Indices de la tabla `sale_product`
--
ALTER TABLE `sale_product`
    ADD PRIMARY KEY (`id`),
  ADD KEY `saleId` (`sale_id`),
  ADD KEY `productId` (`product_id`);

--
-- Indices de la tabla `shopping_cart`
--
ALTER TABLE `shopping_cart`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_id_2` (`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indices de la tabla `shopping_cart_product`
--
ALTER TABLE `shopping_cart_product`
    ADD PRIMARY KEY (`id`),
  ADD KEY `shopping_cart_id` (`shopping_cart_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `shopping_cart_id_2` (`shopping_cart_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `roleId` (`role_id`),
  ADD KEY `roleId_2` (`role_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `comment`
--
ALTER TABLE `comment`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `image`
--
ALTER TABLE `image`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `product`
--
ALTER TABLE `product`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `question`
--
ALTER TABLE `question`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `sale`
--
ALTER TABLE `sale`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `sale_product`
--
ALTER TABLE `sale_product`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `shopping_cart`
--
ALTER TABLE `shopping_cart`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `shopping_cart_product`
--
ALTER TABLE `shopping_cart_product`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comment`
--
ALTER TABLE `comment`
    ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`sale_product_id`) REFERENCES `sale_product` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `image`
--
ALTER TABLE `image`
    ADD CONSTRAINT `image_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `product`
--
ALTER TABLE `product`
    ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `question`
--
ALTER TABLE `question`
    ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `question_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `sale`
--
ALTER TABLE `sale`
    ADD CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `sale_product`
--
ALTER TABLE `sale_product`
    ADD CONSTRAINT `sale_product_ibfk_1` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `sale_product_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `shopping_cart`
--
ALTER TABLE `shopping_cart`
    ADD CONSTRAINT `shopping_cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `shopping_cart_product`
--
ALTER TABLE `shopping_cart_product`
    ADD CONSTRAINT `FKectgy7yh5dy3261o4rei8suxq` FOREIGN KEY (`shopping_cart_id`) REFERENCES `shopping_cart` (`id`),
  ADD CONSTRAINT `shopping_cart_product_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
    ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
