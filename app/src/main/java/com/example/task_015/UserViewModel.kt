//
package com.example.task_015

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class User(val name: String, val age: Int) {
    override fun toString() = "name -$name age - $age";
}

class UserViewModel: ViewModel() {
    val listUsers = ArrayList<User>()
    val mListUsers : MutableLiveData<MutableList<User>> by lazy {MutableLiveData<MutableList<User>>()}
}