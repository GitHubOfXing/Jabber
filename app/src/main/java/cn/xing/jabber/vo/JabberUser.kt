package cn.xing.jabber.vo

import cn.xing.xlib_account.AccountUser

class JabberUser {

    var uid: String = ""
    var userName: String = ""
    var userAvatar: String = ""
    var sex: Int = -1
    var level: Int = -1
    var balance: Long = 0

    var phone: String = ""
    var email: String = ""

    companion object {
        fun transferUser(externalUser: JabberUser): AccountUser {
            val user = AccountUser()
            user.apply {
                userUid = externalUser.uid
                userName = externalUser.userName
                userSex = externalUser.sex
                userAvatar = externalUser.userAvatar
                userSex = externalUser.sex
                userLevel = externalUser.level
                accountBalance = externalUser.balance
                userPhone = externalUser.phone
                userEmail = externalUser.email
            }
            return user
        }
    }
}