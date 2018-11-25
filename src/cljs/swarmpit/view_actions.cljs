(ns swarmpit.view-actions
  (:require [swarmpit.component.page-login :as page-login]
            [swarmpit.component.page-403 :as page-403]
            [swarmpit.component.page-404 :as page-404]
            [swarmpit.component.page-error :as page-error]
            [swarmpit.component.password :as password]
            [swarmpit.component.api-access :as api-access]
            [swarmpit.component.stack.edit :as stack-edit]
            [swarmpit.component.stack.compose :as stack-compose]
            [swarmpit.component.stack.create :as stack-create]
            [swarmpit.component.stack.info :as stack-info]
            [swarmpit.component.stack.list :as stack-list]
            [swarmpit.component.service.create-config :as service-config]
            [swarmpit.component.service.create-image :as service-image]
            [swarmpit.component.service.edit :as service-edit]
            [swarmpit.component.service.info :as service-info]
            [swarmpit.component.service.log :as service-log]
            [swarmpit.component.service.list :as service-list]
            [swarmpit.component.network.create :as network-create]
            [swarmpit.component.network.info :as network-info]
            [swarmpit.component.network.list :as network-list]
            [swarmpit.component.volume.create :as volume-create]
            [swarmpit.component.volume.info :as volume-info]
            [swarmpit.component.volume.list :as volume-list]
            [swarmpit.component.secret.create :as secret-create]
            [swarmpit.component.secret.info :as secret-info]
            [swarmpit.component.secret.list :as secret-list]
            [swarmpit.component.config.create :as config-create]
            [swarmpit.component.config.info :as config-info]
            [swarmpit.component.config.list :as config-list]
            [swarmpit.component.node.list :as node-list]
            [swarmpit.component.node.info :as node-info]
            [swarmpit.component.node.edit :as node-edit]
            [swarmpit.component.task.list :as task-list]
            [swarmpit.component.task.info :as task-info]
            [swarmpit.component.user.list :as user-list]
            [swarmpit.component.user.info :as user-info]
            [swarmpit.component.user.create :as user-create]
            [swarmpit.component.user.edit :as user-edit]
            [swarmpit.component.registry.info :as registry-info]
            [swarmpit.component.registry.list :as registry-list]
            [swarmpit.component.registry.create :as registry-create]
            [swarmpit.component.registry.edit :as registry-edit]
            [swarmpit.component.dockerhub.info :as dockerhub-info]
            [swarmpit.component.dockerhub.list :as dockerhub-list]
            [swarmpit.component.dockerhub.create :as dockerhub-create]
            [swarmpit.component.dockerhub.edit :as dockerhub-edit]))

(defmulti render (fn [route] (:handler route)))

(defmethod render :default
  [_])

(defmethod render :index
  [_]
  {:title "Home"})

(defmethod render :api-access
  [_]
  {:title "API access"})

(defmethod render :password
  [_]
  {:title "Change password"})

;;; Stack view

(defmethod render :stack-list
  [_]
  {:title     "Stacks"
   :search-fn stack-list/form-search-fn
   :actions   stack-list/form-actions})

(defmethod render :stack-info
  [_]
  {:title "Stacks"})

(defmethod render :stack-create
  [_]
  {:title "Stacks / Create"})

(defmethod render :stack-last
  [_]
  {:title "Stacks / Edit"})

(defmethod render :stack-previous
  [_]
  {:title "Stacks / Edit"})

(defmethod render :stack-compose
  [_]
  {:title "Stacks / Edit"})

;;; Service view

(defmethod render :service-list
  [_]
  {:title     "Services"
   :search-fn service-list/form-search-fn
   :actions   service-list/form-actions})

(defmethod render :service-info
  [route]
  {:title   "Services"
   :actions (service-info/form-actions route)})

(defmethod render :service-log
  [_]
  {:title "Services / Log"})

(defmethod render :service-create-image
  [_]
  {:title "Services / Wizard"})

(defmethod render :service-create-config
  [_]
  {:title "Services / Wizard"})

(defmethod render :service-edit
  [_]
  {:title "Services / Edit"})

;;; Network view

(defmethod render :network-list
  [_]
  {:title     "Networks"
   :search-fn network-list/form-search-fn
   :actions   network-list/form-actions})

(defmethod render :network-info
  [route]
  {:title   "Networks"
   :actions (network-info/form-actions route)})

(defmethod render :network-create
  [_]
  {:title "Networks / Create"})

;;; Node view

(defmethod render :node-list
  [_]
  {:title     "Nodes"
   :search-fn node-list/form-search-fn})

(defmethod render :node-info
  [_]
  {:title "Nodes"})

(defmethod render :node-edit
  [_]
  {:title "Nodes / Edit"})

;;; Volume view

(defmethod render :volume-list
  [_]
  {:title     "Volumes"
   :search-fn volume-list/form-search-fn
   :actions   volume-list/form-actions})

(defmethod render :volume-info
  [route]
  {:title   "Volumes"
   :actions (volume-info/form-actions route)})

(defmethod render :volume-create
  [_]
  {:title "Volumes / Create"})

;;; Secret view

(defmethod render :secret-list
  [_]
  {:title     "Secrets"
   :search-fn secret-list/form-search-fn
   :actions   secret-list/form-actions})

(defmethod render :secret-info
  [route]
  {:title   "Secrets"
   :actions (secret-info/form-actions route)})

(defmethod render :secret-create
  [_]
  {:title "Secrets / Create"})

;;; Config view

(defmethod render :config-list
  [_]
  {:title     "Configs"
   :search-fn config-list/form-search-fn
   :actions   config-list/form-actions})

(defmethod render :config-info
  [route]
  {:title   "Configs"
   :actions (config-info/form-actions route)})

(defmethod render :config-create
  [_]
  {:title "Configs / Create"})

;;; Task view

(defmethod render :task-list
  [_]
  {:title     "Tasks"
   :search-fn task-list/form-search-fn})

(defmethod render :task-info
  [_]
  {:title "Tasks"})

;;; User view

(defmethod render :user-list
  [_]
  {:title     "Users"
   :search-fn user-list/form-search-fn
   :actions   user-list/form-actions})

(defmethod render :user-info
  [route]
  {:title   "Users"
   :actions (user-info/form-actions route)})

(defmethod render :user-create
  [_]
  {:title "Users / Create"})

(defmethod render :user-edit
  [_]
  {:title "Users / Edit"})

;;; Registry view

(defmethod render :registry-list
  [_]
  {:title     "Registries"
   :search-fn registry-list/form-search-fn
   :actions   registry-list/form-actions})

(defmethod render :registry-info
  [route]
  {:title   "Registries"
   :actions (registry-info/form-actions route)})

(defmethod render :registry-create
  [_]
  {:title "Registries / Create"})

(defmethod render :registry-edit
  [_]
  {:title "Registries / Edit"})

;;; Dockerhub user view

(defmethod render :dockerhub-user-list
  [_]
  {:title     "Dockerhub"
   :search-fn dockerhub-list/form-search-fn
   :actions   dockerhub-list/form-actions})

(defmethod render :dockerhub-user-info
  [route]
  {:title   "Dockerhub"
   :actions (dockerhub-info/form-actions route)})

(defmethod render :dockerhub-user-create
  [_]
  {:title "Dockerhub / Create"})

(defmethod render :dockerhub-user-edit
  [_]
  {:title "Dockerhub / Edit"})