package com.example.android_sample.core.interactor

import com.example.android_sample.core.exception.Failure
import com.example.android_sample.core.functional.Either
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<out Type, in Params> where Type : Any {
    private var coroutine = CoroutineScope(Dispatchers.Main)
    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        val job = coroutine?.async(Dispatchers.Default) { run(params) }
        coroutine?.launch(Dispatchers.Unconfined) {
            if (job != null) {
                onResult(job.await())
            }
        }
    }

    class None
}