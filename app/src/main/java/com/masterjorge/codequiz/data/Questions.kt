package com.masterjorge.codequiz.data

import com.masterjorge.codequiz.R

//Perguntas do Python
val questionsPython = listOf(
    Question(
        image = R.drawable.python_bg,
        description = "O que significa Python?",
        options = listOf(
            Option ("É linguagem de programação de backend", true, 2),
            Option ("É um sistema operacional", false),
            Option ( "É linguagem de programação de frontend", false),
            Option ("É Um interpretador", false),
        ),
    ) ,
    Question(
        image = R.drawable.python_bg,
        description = "Em Python, qual o resultado da expressão 2%2?",
        options = listOf(
            Option ("1", false),
            Option ( "0.5", false),
            Option ( "0", true, 1),
            Option ("4", false),
        ),
    ),
    Question(
        image = R.drawable.python_bg,
        description = "Em Python, que faz a função 'append' em uma lista?",
        options = listOf(
            Option ("Separa um elemento aleatório da lista", false),
            Option ( "Une um elemento ao final da lista", true, 3),
            Option ( "Une uma lista com outra lista", false),
            Option ("Insere um elemento em uma posição específica por parte do usuário", false),
        ),
    ),

)

//Perguntas do Python
val questionsKotlin = listOf(
    Question(
        image = R.drawable.kotlin_bg,
        description = "O que é o Kotlin?",
        options = listOf(
            Option ("Uma linguagem de programação", true, 2),
            Option ( "Um sistema operacional", false),
            Option ( "Um compilador", false),
            Option ( "Um interpretador", false),
        ),
    ),

    Question(
        image = R.drawable.kotlin_bg,
        description = "Qual o resultado da expressão 2/2?",
        options = listOf(
            Option ( "1", true, 1),
            Option ( "2.5", false),
            Option ( "0", false),
            Option ( "4", false),
        ),
    ),

    Question(
        image = R.drawable.kotlin_bg,
        description = "Que tipo de problema o Kotlin evita em relação ao Java?",
        options = listOf(
            Option ( "Não existe diferença entre os dois", false),
            Option ( "Evita trabalhar com o orientação a objeto", false),
            Option ( "Evita elementos nulos", true, 3),
            Option ( "Evita ponto e vírgula", false),
        ),
    ),

    )