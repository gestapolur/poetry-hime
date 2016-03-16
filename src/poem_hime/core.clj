(ns poem-hime.core
  (:gen-class)
  (:require [clojure.data.json :as json])
  (:require [org.httpkit.client :as http])
  (:use
   [twitter.oauth]
   [twitter.callbacks]
   [twitter.callbacks.handlers]
   [twitter.api.restful])
  (:import
   (twitter.callbacks.protocols SyncSingleCallback)
   (java.net URLEncoder)))

(def my-creds (make-oauth-creds *app-consumer-key*
                                *app-consumer-secret*
                                *user-access-token*
                                *user-access-token-secret*))


(defn get-random-poem
  []
  (let [response
        (http/get (str *bosonnlp-poem-generating-api*
                       ((shuffle [5 7]) 0)))]
    (json/read-str (:body @response))))


(defn -main
  [& args]
  (def dt (get-random-poem))
  (statuses-update :oauth-creds my-creds
                   :params {:status (dt "text")}))
