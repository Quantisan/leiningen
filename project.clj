;; This is Leiningen's own project configuration. See doc/TUTORIAL.md
;; file as well as sample.project.clj for help writing your own.

(defproject leiningen "2.0.0-preview8"
  :description "Automate Clojure projects without setting your hair on fire."
  :url "https://github.com/technomancy/leiningen"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[leiningen-core "2.0.0-preview8"]
                 [org.clojure/data.xml "0.0.3"]
                 [bultitude "0.1.7"]
                 [org.apache.maven.indexer/indexer-core "4.1.3"
                  :exclusions [org.apache.maven/maven-model
                               org.sonatype.aether/aether-api
                               org.sonatype.aether/aether-util]]
                 [reply "0.1.0-beta10" :exclusions [ring/ring-core]]
                 [clj-http "0.4.2"]]
  ;; checkout-deps don't work with :eval-in :leiningen
  :profiles {:dev {:resource-paths ["leiningen-core/dev-resources"]
                   :test-paths ["leiningen-core/test"]}
             :release {:aot [#"leiningen"
                             cemerick.pomegranate
                             cemerick.drawbridge
                             classlojure.core
                             clojure.tools.nrepl
                             clj-http.core
                             ordered.map]}}
  :test-selectors {:default (complement :post-preview)
                   :offline (complement :online)}
  :source-paths ["leiningen-core/src" "src"]
  ;; work around Clojure bug http://dev.clojure.org/jira/browse/CLJ-1034
  :uberjar-exclusions [#"^data_readers.clj$"]
  :eval-in :leiningen)
