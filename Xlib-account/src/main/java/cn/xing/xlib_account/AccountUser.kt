package cn.xing.xlib_account

class AccountUser {

    var userUid: String = ""
    var userName: String = ""
    var userAvatar: String = ""
    var userSex: Int = -1
    var userLevel: Int = -1
    var accountBalance: Long = 0

    var userPhone: String = ""
    var userEmail: String = ""

    enum class AccountState {
        UNLOGIN, LOGIN,VISIT
    }


}