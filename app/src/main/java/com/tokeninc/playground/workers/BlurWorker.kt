package com.tokeninc.playground.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class BlurWorker(ctx: Context, params: WorkerParameters ): Worker(ctx, params) {


    override fun doWork(): Result {
        return Result.success()

    }

}