package com.erikmedina.article.domain.interactor

import com.erikmedina.article.data.local.model.ItemView
import com.erikmedina.article.domain.repository.Repository
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class GetContentListInteractorImpl
@Inject
constructor(private val repository: Repository) : GetContentListInteractor {

    private lateinit var callback: GetContentListInteractor.Callback

    override fun run(callback: GetContentListInteractor.Callback) {
        this.callback = callback
        execute()
    }

    override fun execute() {
        launch(UI) {
            repository.getContentList(object : Repository.Callback<List<ItemView>> {
                override fun onSuccess(itemViews: List<ItemView>) {
                    callback.onSuccess(itemViews)
                }

                override fun onError(throwable: Throwable) {
                    callback.onError(throwable)
                }
            })
        }
    }
}
