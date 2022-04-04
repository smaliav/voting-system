package ru.smaliav.fiks.domain.user

enum class UserRole(val rank: String) {
    FOUNDER ("Основатель"),
    ADMIN   ("Администратор"),
    BASE    ("Базовый"),
    SPECIAL ("Эксперт"),
    PRO     ("ПРО"),
}
