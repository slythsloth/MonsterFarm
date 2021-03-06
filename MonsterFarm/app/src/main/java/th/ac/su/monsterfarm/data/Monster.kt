package th.ac.su.monsterfarm.data

data class Monster(
    val imageFile: String,
    val  monsterName: String,
    val caption:  String,
    val description:  String,
    val price:  Double,
    val scariness:  Int
)