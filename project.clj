(defproject poem-hime "0.1.0-SNAPSHOT"
  :description "Twitter frontend of an ancient Chinese poem-making bot."
  :url "http://poem.bosonnlp.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.1.19"]
                 [org.clojure/data.json "0.2.6"]
                 [twitter-api "0.7.8"]]
  :main ^:skip-aot poem-hime.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
