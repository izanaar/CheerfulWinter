/**
 * Cheerful Winter application consists from 2 modules: study and translate. Respectively, 'translate' subpackage
 * contains translation only functionality, and 'study' - study. Interaction between these modules is not bi-directional.
 * Translate module adds translations into common database, using {@link com.izanaar.chwin.translate.dto.Translation}consumer, that's it.
 * On the other side, study module uses information, produced by translation module to provide user with words, need to
 * be studied.
 */
package com.izanaar.chwin;
