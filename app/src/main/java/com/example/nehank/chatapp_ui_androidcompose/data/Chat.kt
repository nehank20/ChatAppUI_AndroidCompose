package com.example.nehank.chatapp_ui_androidcompose.data



data class Chat(
    val id:Int,
    val message:String,
    val time:String,
    val direction:Boolean
)

val chatList = listOf(
    Chat(
        1,
        "Hey! How have you been?",
        "12:15 PM",
        true
    ),
    Chat(
        2,
        "Wanna catch up for a beer?",
        "12:17 PM",
        true
    ),
    Chat(
        3,
        "Awesome! Let’s meet up",
        "12:19 PM",
        false
    ),
    Chat(
        4,
        "Can I also get my cousin along? Will that be okay?",
        "12:20 PM",
        false
    ),
    Chat(
        5,
        "Yeah sure! get him too.",
        "12:21 PM",
        true
    ),
    Chat(
        6,
        "Hey! How have you been?",
        "12:15 PM",
        false
    ),
    Chat(
        7,
        "Wanna catch up for a beer?",
        "12:17 PM",
        true
    ),
    Chat(
        8,
        "Awesome! Let’s meet up",
        "12:19 PM",
        false
    ),
    Chat(
        9,
        "Can I also get my cousin along? Will that be okay?",
        "12:20 PM",
        false
    ),
    Chat(
        10,
        "Yeah sure! get him too.",
        "12:21 PM",
        true
    ),
    Chat(
        11,
        "Meet up at Joey's ? ",
        "12:22 PM",
        true
    ),
    Chat(
        12,
        "Sounds cool. I will get my bike",
        "12:22 PM",
        false
    ),
    Chat(
        13,
        "Great. See you at 7",
        "12:23 PM",
        true
    ),
    Chat(
        14,
        "Alright",
        "12:25 PM",
        false
    ),

)