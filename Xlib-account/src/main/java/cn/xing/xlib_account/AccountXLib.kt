package cn.xing.xlib_account

class AccountXLib {

    private var accountUser: AccountUser? = null
    private var appUserState: AccountUser.AccountState = AccountUser.AccountState.UNLOGIN

    fun accountLogin(inflateUser: (accountUser: AccountUser) -> Unit) {
        if(null == accountUser) {
            accountUser = AccountUser()
        }
        inflateUser(accountUser!!)
        appUserState = AccountUser.AccountState.LOGIN
    }

    fun accountLogout() {
        accountUser = null
        appUserState = AccountUser.AccountState.UNLOGIN
    }

}