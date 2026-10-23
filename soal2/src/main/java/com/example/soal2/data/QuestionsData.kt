package com.example.soal2.data

import com.example.soal2.model.Question

object QuestionsData {

    val questions = listOf(
        Question(
            question = "What is the capital of Indonesia as of 2026?",
            correctAnswer = "Jakarta",
            wrongAnswers = listOf(
                "Nusantara",
                "Surabaya",
                "Medan"
            ),
            explanation = "The current capital city of Indonesia as of 2026 is Jakarta."
        ),
        Question(
            question = "Who was the second president of Indonesia?",
            correctAnswer = "Suharto",
            wrongAnswers = listOf(
                "B. J. Habibie",
                "Megawati Soekarnoputri",
                "Abdurrahman Wahid"
            ),
            explanation = "B. J. Habibie is the 3rd, Abdurrahman Wahid is the 4th and Megawati Soekarnoputri is the 5th."
        ),

        Question(
            question = "What is the fourth state of matter?",
            correctAnswer = "Plasma",
            wrongAnswers = listOf(
                "Bose-Einstein condensate",
                "Radiation",
                "Electricity"
            ),
            explanation = "Bose-Einstein condensate is the fifth state of matter, radiation and electricity are not states of matter."
        ),

        Question(
            question = "Which is the coldest planet in our solar system?",
            correctAnswer = "Uranus",
            wrongAnswers = listOf(
                "Neptune",
                "Saturn",
                "Pluto"
            ),
            explanation = "Neptune is the furthest planet but Uranus is colder. Pluto is not a planet and Saturn is not the coldest."
        ),
        Question(
            question = "Who is the richest person in the world as of 2026?",
            correctAnswer = "Elon Musk",
            wrongAnswers = listOf(
                "Jeff Bezos",
                "Mark Zuckerberg",
                "Bill Gates"
            ),
            explanation = "Jeff Bezos is ranked 2nd, Mark Zuckerberg ranked 6th, and Bill Gates is out of the top 10."
        ),
        Question(
            question = "Who invented the light bulb?",
            correctAnswer = "Thomas Edison",
            wrongAnswers = listOf(
                "Nikola Tesla",
                "Alexander Graham Bell",
                "Benjamin Franklin"
            ),
            explanation = "Nikola Tesla invented Alternating-current, Alexander Graham Bell invented the telephone and Benjamin Franklin invented several others including the lightning rod, bifocal glasses, and Franklin stove."
        ),
        Question(
            question = "Mixing blue light and red light produces which colour?",
            correctAnswer = "Magenta",
            wrongAnswers = listOf(
                "Purple",
                "Cyan",
                "Yellow"
            ),
            explanation = "Light uses additive colour mixing, meaning blue and red make Magenta."
        ),

        Question(
            question = "Mixing blue paint and red paint produces which colour?",
            correctAnswer = "Purple",
            wrongAnswers = listOf(
                "Magenta",
                "Cyan",
                "Yellow"
            ),
            explanation = "Paint uses subtractive colour mixing, meaning blue and red make Purple."
        ),

        Question(
            question = "Fire needs which three things to form?",
            correctAnswer = "Fuel, heat, and oxygen",
            wrongAnswers = listOf(
                "Fuel, heat, and nitrogen",
                "Fuel, heat, and carbon-dioxide",
                "Fuel, heat, and gas"
            ),
            explanation = "Oxygen is needed for fire because it supports combustion, allowing fuel to burn."
        ),

        Question(
            question = "Which programming language is used in this app?",
            correctAnswer = "Kotlin",
            wrongAnswers = listOf(
                "Java",
                "Python",
                "HTML"
            ),
            explanation = "If you get this wrong, you're not an IMT student."
        ),

        Question(
            question = "What is the world's largest land carnivore?",
            correctAnswer = "Polar bear",
            wrongAnswers = listOf(
                "African Elephant",
                "Siberian tiger",
                "African lion"
            ),
            explanation = "The biggest animal here is the elephant but it is an herbivore. The second biggest listed here are polar bears which can be around 2.4 – 3 meters tall."
        ),

        Question(
            question = "What is the chemical formula of table salt?",
            correctAnswer = "NaCl",
            wrongAnswers = listOf(
                "NaClO",
                "Na₂CO₃",
                "KCl"
            ),
            explanation = "NaClO is Sodium hypochlorite, Na₂CO₃ is Sodium carbonate and KCl is Potassium chloride."
        ),

        Question(
            question = "USB port colours are commonly used to indicate data transfer speed. Which of these is the fastest?",
            correctAnswer = "Orange",
            wrongAnswers = listOf(
                "Black",
                "White",
                "Blue"
            ),
            explanation = "Whites are 12 Mbps, black is 480 Mbps, blue is typically 5 Gbps or higher, and other colours are higher than those other 3."
        ),

        Question(
            question = "On a typical gaming mouse with two side buttons, what is the front side button commonly called?",
            correctAnswer = "Mouse Button 5",
            wrongAnswers = listOf(
                "Mouse Button 2",
                "Mouse Button 3",
                "Mouse Button 4"
            ),
            explanation = "MB2 is right click, MB 3 is middle mouse, and MB4 is the back side button."
        ),

        Question(
            question = "These are all brass instruments, except which one?",
            correctAnswer = "Saxophone",
            wrongAnswers = listOf(
                "Trumpet",
                "Tuba",
                "Flugelhorn"
            ),
            explanation = "The saxophone is classified as a woodwind instrument."
        ),

        Question(
            question = "How do you put out fire from an oil pot?",
            correctAnswer = "Cover it with a metal lid and turn off the heat",
            wrongAnswers = listOf(
                "Pour water into the pot",
                "Carry the burning pot outside",
                "Blow on the flames until they go out"
            ),
            explanation = "Never use water on burning cooking oil. It can cause the burning oil to splatter violently and spread the fire. The best way is to simply turn of the heat and strip the fire of oxygen."
        ),

        Question(
            question = "Which Vitamin do you get for going out in the sun?",
            correctAnswer = "Vitamin D",
            wrongAnswers = listOf(
                "Vitamin A",
                "Vitamin B",
                "Vitamin C"
            ),
            explanation = "Vitamin A comes from carrots, sweet potatoes, spinach, eggs and liver. Vitamin B comes from meat, eggs, whole grains, beans and nuts. Vitamin C comes from oranges, lemons, guava, strawberries and bell peppers. Vitamin D can also come from certain foods but its main form is in sunlight."
        ),

        Question(
            question = "What is 2 + 4 * 5 - 10 = ?",
            correctAnswer = "12",
            wrongAnswers = listOf(
                "16",
                "20",
                "24"
            ),
            explanation = "Using the order of mathematics: 4 * 5 = 20 | 2 + 20 = 22 | 22 - 10 = 12."
        ),

        Question(
            question = "The keyboard shortcut used for deleting a tab on Google is?",
            correctAnswer = "ctrl + w",
            wrongAnswers = listOf(
                "ctrl + shift + w",
                "ctrl + t",
                "ctrl + shift + t"
            ),
            explanation = "ctrl + shift + w closes the entire window, ctrl + t opens a new tab, and Ctrl + Shift + T reopens the most recently closed tab."
        ),

        Question(
            question = "Which sentence does NOT contain a grammatical error?",
            correctAnswer = "This is your pair of scissors",
            wrongAnswers = listOf(
                "Thoose are actually mine",
                "Its actually called a panda",
                "Five is definitely greater then four"
            ),
            explanation = "'Thoose' is spelled 'Those', The word 'Its' is actually supposed to be 'It's', and the 'then' is supposed to be 'than' in that sentence. And while scissors is plural, because its a pair, it becomes singular. Meaning 'This is' is used over 'These are'."
        )
    )
}