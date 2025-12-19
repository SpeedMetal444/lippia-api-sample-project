package api.config;

import services.*;

public enum EntityConfiguration {

    WORKSPACE {
        @Override
        public Class<?> getEntityService() {
            return WorkspaceService.class;
        }
    },

    PROJECT {
        @Override
        public Class<?> getEntityService() {
            return ProjectService.class;
        }
    },

    CLIENT {
        @Override
        public Class<?> getEntityService() {
            return ClientService.class;
        }
    },

    TIME_ENTRY {
        @Override
        public Class<?> getEntityService() {
            return TimeEntryService.class;
        }
    },

    CLOCKIFY_USER {
        @Override
        public Class<?> getEntityService() {
            return ClockifyUserService.class;
        }
    };
    public abstract Class<?> getEntityService();
}
