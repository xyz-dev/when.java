/*
 * The MIT License (MIT)
 * Copyright © 2013 Englishtown <opensource@englishtown.com>
 * http://englishtown.mit-license.org/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the “Software”), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.englishtown.promises;

/**
 * A {@link Thenable} object that "promises" to fulfill or reject either immediately or at some point in the future.
 *
 * @param <TResolve>  the type passed to fulfillment or rejection handlers
 * @param <TProgress> the type passed to progress handlers
 */
public interface Promise<TResolve, TProgress> extends Thenable<TResolve, TProgress> {

    /**
     * Registers a callback for when a promise resolves
     *
     * @param onFulfilled resolution handler
     * @return a new {@link Promise} to allow chaining callback registration
     */
    Promise<TResolve, TProgress> then(
            Runnable<Promise<TResolve, TProgress>, TResolve> onFulfilled);

    /**
     * Registers callbacks for when a promise resolves or rejects
     *
     * @param onFulfilled resolution handler
     * @param onRejected  rejection handler
     * @return a new {@link Promise} to allow chaining callback registration
     */
    Promise<TResolve, TProgress> then(
            Runnable<Promise<TResolve, TProgress>, TResolve> onFulfilled,
            Runnable<Promise<TResolve, TProgress>, Value<TResolve>> onRejected);

}
